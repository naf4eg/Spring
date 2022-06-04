package ru.naf4eg.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import ru.naf4eg.example.controller.LoginController;

import javax.sql.DataSource;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    /*Custom login form*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").hasRole(Roles.EMPLOYEE.name())
                .antMatchers("/admins/**").hasRole(Roles.ADMIN.name())
                .antMatchers("/managers/**").hasRole(Roles.MANAGER.name())
                .and()
                    .formLogin()
                        .loginPage(LoginController.LOGIN_PAGE_URL)
                        .loginProcessingUrl("/authTheUser")
                        .permitAll()
                .and()
                    .logout()
                    .permitAll()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage(LoginController.ACCESS_DENIED_URL);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);

//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(
//                        userBuilder.username("Kostya")
//                                .password("123")
//                                .roles(Roles.EMPLOYEE.name())
//                )
//                .withUser(
//                        userBuilder.username("Mary")
//                                .password("1234")
//                                .roles(Roles.MANAGER.name(), Roles.EMPLOYEE.name())
//                )
//                .withUser(
//                        userBuilder.username("Dima")
//                                .password("12345")
//                                .roles(Roles.ADMIN.name(), Roles.EMPLOYEE.name())
//                );
    }
}
