package ru.annotation.java.engine;

import org.springframework.stereotype.Component;
import ru.common.Engine;

@Component("h23")
public class H23 implements Engine {
    @Override
    public String getPower() {
        return "200 л.с.";
    }
}
