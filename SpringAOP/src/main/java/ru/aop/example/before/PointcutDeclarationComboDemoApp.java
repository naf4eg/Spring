package ru.aop.example.before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.before.configuration.DemoConfiguration;
import ru.aop.example.before.dao3.DictionaryDAO;

public class PointcutDeclarationComboDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        var bean1 = ctx.getBean(DictionaryDAO.class);
        bean1.fillDictionary();
        bean1.getField();
        bean1.setField("fieldName");
    }
}
