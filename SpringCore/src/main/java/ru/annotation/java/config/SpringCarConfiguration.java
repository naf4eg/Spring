package ru.annotation.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.annotation.java.cars.LandRover;
import ru.annotation.java.engine.DTD204;
import ru.common.Car;
import ru.common.Engine;

@Configuration
@ComponentScan("ru.annotation.java")
@PropertySource("classpath:application.properties")
public class SpringCarConfiguration {

    @Bean
    Engine landRover204DTD() {
        return new DTD204();
    }

    @Bean
    Car landRover() {
        return new LandRover(landRover204DTD());
    }
}
