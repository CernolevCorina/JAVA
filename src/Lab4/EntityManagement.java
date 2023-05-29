package Lab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Entity {
    protected String name;
    protected int money;

    public Entity(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public abstract void displayDetails();

    public abstract void updateData(String attribute, String newValue);
}

class Person extends Entity {
    private int age;

    public Person(String name, int age, int money) {
        super(name, money);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Money: " + money);
    }

    @Override
    public void updateData(String attribute, String newValue) {
        if (attribute.equalsIgnoreCase("name")) {
            name = newValue;
        } else if (attribute.equalsIgnoreCase("age")) {
            age = Integer.parseInt(newValue);
        } else if (attribute.equalsIgnoreCase("money")) {
            money = Integer.parseInt(newValue);
        } else {
            System.out.println("Invalid attribute.");
        }
    }
}

class Company extends Entity {
    private String industry;

    public Company(String name, String industry, int money) {
        super(name, money);
        this.industry = industry;
    }

    public String getIndustry() {
        return industry;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Industry: " + industry);
        System.out.println("Money: " + money);
    }

    @Override
    public void updateData(String attribute, String newValue) {
        if (attribute.equalsIgnoreCase("name")) {
            name = newValue;
        } else if (attribute.equalsIgnoreCase("industry")) {
            industry = newValue;
        } else if (attribute.equalsIgnoreCase("money")) {
            money = Integer.parseInt(newValue);
        } else {
            System.out.println("Invalid attribute.");
        }
    }
}

public class EntityManagement {
    public static void main(String[] args) {
        List<Entity> entities = readEntityDataFromFile("D:\\New folder\\Project1\\Project1\\src\\resources\\Lab4-input.txt");

        if (entities != null) {
            System.out.println("Entities before sorting:");
            displayEntities(entities);

            Collections.sort(entities, (e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));

            System.out.println("Entities after sorting:");
            displayEntities(entities);

            int totalMoney = calculateTotalMoney(entities);
            System.out.println("Total money required: " + totalMoney);

            String attribute = "name";
            displayRecordDetails(entities, attribute);
            // Updating data
            Entity entityToUpdate = entities.get(1);
            entityToUpdate.updateData("age", "30");
            entityToUpdate.displayDetails();
        }
    }

    private static List<Entity> readEntityDataFromFile(String fileName) {
        List<Entity> entities = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length >= 4) {
                    String entityType = data[0];
                    String name = data[1];
                    int money = Integer.parseInt(data[2]);

                    if (entityType.equalsIgnoreCase("person")) {
                        int age = Integer.parseInt(data[3]);
                        entities.add(new Person(name, age, money));
                    } else if (entityType.equalsIgnoreCase("company")) {
                        String industry = data[3];
                        entities.add(new Company(name, industry, money));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + fileName);
            return null;
        } catch (IOException e) {
            System.out.println("Error reading data from file: " + fileName);
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in input file: " + fileName);
            return null;
        }

        return entities;
    }

    private static void displayEntities(List<Entity> entities) {
        for (Entity entity : entities) {
            entity.displayDetails();
            System.out.println();
        }
    }

    private static int calculateTotalMoney(List<Entity> entities) {
        int totalMoney = 0;
        for (Entity entity : entities) {
            totalMoney += entity.getMoney();
        }
        return totalMoney;
    }

    private static void displayRecordDetails(List<Entity> entities, String attribute) {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(attribute)) {
                entity.displayDetails();
                break;
            }
        }
    }
}
