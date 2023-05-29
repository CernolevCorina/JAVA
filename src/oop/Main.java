package oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Entity> entityList = buildEntityList("D:\\New folder\\Project1\\Project1\\src\\resources\\entity-input.txt");
            System.out.println(entityList);
            orderList(entityList);
            printEntityList(entityList);
            System.out.println("Total money needed to manage all entities: " + getTotalMoney(entityList));
            changeData(entityList);
            String attribute = getUserInput();
            printEntityDetails(entityList, attribute);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (NumberFormatException e) {
            System.err.println("One or both entered numbers is not valid.");
        } catch (NullPointerException e) {
            System.err.println("One or both entered numbers are null.");
        } catch (ArithmeticException e) {
            System.err.println("Can't divide by zero.");
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Invalid input.");
        }
    }

    public static List<Entity> buildEntityList(String filename) throws FileNotFoundException {
        List<Entity> entityList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] fields = line.split("\\|");

            String name = fields[0].trim();
            double money = Double.parseDouble(fields[1].trim());
            String type = fields[2].trim();

            if (type.equals("Person")) {
                int age = Integer.parseInt(fields[3].trim());
                entityList.add(new Person(name, money, age));
            } else if (type.equals("Organization")) {
                String industry = fields[3].trim();
                entityList.add(new Organization(name, money, industry));
            }
        }

        scanner.close();
        return entityList;
    }

    public static void orderList(List<Entity> entityList) {
        Collections.sort(entityList, new Comparator<Entity>() {
            @Override
            public int compare(Entity e1, Entity e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });
    }

    public static void printEntityList(List<Entity> entityList) {
        for (Entity entity : entityList) {
            System.out.println(entity.getInfo());
        }
    }

    public static double getTotalMoney(List<Entity> entityList) {
        double totalMoney = 0;

        for (Entity entity : entityList) {
            totalMoney += entity.getMoney();
        }

        return totalMoney;
    }

    public static void changeData(List<Entity> entityList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the entity to change: ");
        String name = scanner.nextLine();

        for (Entity entity : entityList) {
            if (entity.getName().equals(name)) {
                System.out.print("Enter the new amount of money: ");
                double money = scanner.nextDouble();
                entity.setMoney(money);
                System.out.println("Data updated.");
                break;
            }
        }

        scanner.close();
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an attribute to search for: ");
        String attribute = scanner.nextLine();
        scanner.close();
        return attribute;
    }

    public static void printEntityDetails(List<Entity> entityList, String attribute) {
        for (Entity entity : entityList) {
            if (entity.getName().equals(attribute) || entity.getInfo().contains(attribute)) {
                System.out.println(entity.getInfo());
            }
        }
    }
}
