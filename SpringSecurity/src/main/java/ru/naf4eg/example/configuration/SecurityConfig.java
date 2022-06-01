package ru.naf4eg.example.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import ru.naf4eg.example.controller.LoginController;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /*Custom login form*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage(LoginController.LOGIN_PAGE_URL)
                        .loginProcessingUrl("/authTheUser")
                        .permitAll()
                .and()
                    .logout()
                    .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(
                        userBuilder.username("Kostya")
                                .password("123")
                                .roles("EMPLOYEE")
                )
                .withUser(
                        userBuilder.username("Mary")
                                .password("1234")
                                .roles("MANAGER", "EMPLOYEE")
                )
                .withUser(
                        userBuilder.username("Dima")
                                .password("12345")
                                .roles("ADMIN", "EMPLOYEE")
                );
    }
}
