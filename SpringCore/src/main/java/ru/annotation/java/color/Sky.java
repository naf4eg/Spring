package ru.annotation.java.color;

import org.springframework.stereotype.Component;
import ru.common.Color;

@Component
public class Sky implements Color {
    @Override
    public String getColor() {
        return "Blue sky";
    }
}
