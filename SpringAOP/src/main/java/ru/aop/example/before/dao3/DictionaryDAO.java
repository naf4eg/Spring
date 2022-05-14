package ru.aop.example.before.dao3;

import org.springframework.stereotype.Component;

@Component
public class DictionaryDAO {

    private String name;
    private String field;

    public String getName() {
        System.out.println(getClass() + " ====> call  dictionary getName() \n");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " ====> call  dictionary setName(String name) \n");
        this.name = name;
    }

    public String getField() {
        System.out.println(getClass() + " ====> call  dictionary getField() \n");
        return field;
    }

    public void setField(String field) {
        System.out.println(getClass() + " ====> call  dictionary setField(String field) \n");
        this.field = field;
    }

    public void fillDictionary() {
        System.out.println(getClass() + " ====> call  dictionary fillDictionary()\n");
    }
}
