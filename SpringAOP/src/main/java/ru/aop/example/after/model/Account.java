package ru.aop.example.after.model;

public class Account {

    private String number;
    private Type type;

    public Account() {
    }

    public Account(String number, Type type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public enum Type {
        CARD,
        ACCOUNT,
        DEPOSIT
    }
}
