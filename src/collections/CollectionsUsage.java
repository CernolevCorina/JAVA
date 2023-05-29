package collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CollectionsUsage {
    private static StringBuilder ReadString() {
        try {
            File myObj = new File("D:\\New folder\\Project1\\Project1\\src\\resources\\Client-input.txt");
            Scanner myReader = new Scanner(myObj);
            StringBuilder informationBuilder = new StringBuilder();
            while (myReader.hasNextLine()) {
                informationBuilder.append(myReader.nextLine());
            }
            myReader.close();
            return new StringBuilder(informationBuilder.toString());
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public static void CreateFile() {
        try {
            File myObj = new File("D:\\New folder\\Project1\\Project1\\src\\resources\\Client-final.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteToFile(String phrase, FileWriter myWriter) {
        try {
            myWriter.append(phrase + '\n');
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String information = String.valueOf(ReadString());
        String[] arrOfStr = information.split(",");

        //Alphabetical order
        Arrays.sort(arrOfStr);
        for (int i = 0; i < arrOfStr.length; i++) {
            System.out.println(arrOfStr[i]);
        }

        //Distinct first names
        HashSet<String> distinctFirstNames = new HashSet<>();
        for (String client : arrOfStr) {
            String[] nameParts = client.split(" ");
            String firstName = nameParts[0].trim();
            distinctFirstNames.add(firstName);
        }

        System.out.println("List of distinct first names:");
        for (String firstName : distinctFirstNames) {
            System.out.println(firstName);
        }

        // Write to file
        try {
            CreateFile();
            FileWriter myWriter = new FileWriter("D:\\New folder\\Project1\\Project1\\src\\resources\\Client-final.txt");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (String client : arrOfStr) {
                String[] parts = client.split(" ");
                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                System.out.println("Birthdate for: " + client);
                String dateOfBirthString = scanner.nextLine();
                if (parts.length > 2) {
                    dateOfBirthString = parts[2].trim();
                }
                LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString, formatter);
                int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
                String output = firstName + " | " + lastName + " | " + dateOfBirth.format(formatter) + " | " + age + ",";
                WriteToFile(output, myWriter);
            }
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
};
