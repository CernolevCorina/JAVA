package oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public abstract class Entity {
    protected String name;
    protected double money;

    public Entity(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public abstract String getInfo();

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Person extends Entity {
    private int age;

    public Person(String name, double money, int age) {
        super(name, money);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getInfo() {
        return "Name: " + name + " | Age: " + age + " | Money: " + money;
    }
}

class Organization extends Entity {
    private String industry;

    public Organization(String name, double money, String industry) {
        super(name, money);
        this.industry = industry;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String getInfo() {
        return "Name: " + name + " | Industry: " + industry + " | Money: " + money;
    }
}

