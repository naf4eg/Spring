package ru.naf4eg.example.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.function.Consumer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.naf4eg.example")
@PropertySource("classpath:persistence-mysql.properties")
@Slf4j
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();

        log.info("==>>> jdbc.url=" + environment.getProperty("jdbc.url"));
        log.info("==>>> jdbc.driver=" + environment.getProperty("jdbc.driver"));
        log.info("==>>> jdbc.user=" + environment.getProperty("jdbc.user"));

        try {
            pooledDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        pooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        pooledDataSource.setUser(environment.getProperty("jdbc.user"));
        pooledDataSource.setPassword(environment.getProperty("jdbc.password"));
        pooledDataSource.setInitialPoolSize(getIntProp(environment.getProperty("connection.pool.initialPoolSize")));
        pooledDataSource.setMinPoolSize(getIntProp(environment.getProperty("connection.pool.minPoolSize")));
        pooledDataSource.setMaxPoolSize(getIntProp(environment.getProperty("connection.pool.maxPoolSize")));
        pooledDataSource.setMaxIdleTime(getIntProp(environment.getProperty("connection.pool.maxIdleTime")));
        log.info("===>>>> done setting props");

        return pooledDataSource;
    }

    private int getIntProp(String prop) throws NumberFormatException {
        return Integer.parseInt(prop);
    }
}
