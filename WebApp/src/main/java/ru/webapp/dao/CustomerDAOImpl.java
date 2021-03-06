package ru.webapp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.webapp.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        var session = sessionFactory.getCurrentSession();
        var query = session.createQuery(
                "from Customer order by lastName",
                Customer.class);
        var customers = query.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        var session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int id) {
        var session = sessionFactory.getCurrentSession();
        List<Customer> customer = session.createQuery("from Customer where id = :id")
                .setParameter("id", Long.valueOf(id))
                .getResultList();
        return customer.get(0);
    }

    @Override
    public void delete(int id) {
        var session = sessionFactory.getCurrentSession();
        session.createQuery("delete Customer where id=:id")
                .setParameter("id", Long.valueOf(id))
                .executeUpdate();
    }
}
