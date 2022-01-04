package ru.annotation.java.color;

import org.springframework.stereotype.Component;
import ru.common.Color;

@Component
public class Black implements Color {
    @Override
    public String getColor() {
        return "Black";
    }
}
