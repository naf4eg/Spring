package ru.annotation.java.engine;

import org.springframework.stereotype.Component;
import ru.common.Engine;

@Component("fa24f")
public class FA24F implements Engine {
    @Override
    public String getPower() {
        return "264 л.c.";
    }
}
