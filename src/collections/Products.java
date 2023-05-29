package collections;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Products {
    private static HashMap ReadString() {
        HashMap<String, String> productMap = new HashMap<String, String>();

        try {
            File myObj = new File("D:\\New folder\\Project1\\Project1\\src\\resources\\Products-input.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] parts = line.split("\\|");
                String code = parts[0].trim();
                String name = parts[1].trim();
                productMap.put(code, name);
            }
            myReader.close();
            return productMap;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public static void WriteToFile(String phrase, FileWriter myWriter) {
        try {
            myWriter.append(phrase + '\n');
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap productMap = ReadString();


        // Add new products to the HashMap
        productMap.put("P001", "New Product 1");
        productMap.put("P002", "New Product 2");
        productMap.put("P003", "New Product 3");
        productMap.put("P004", "New Product 4");
        productMap.put("P005", "New Product 5");


        // Update the name of the last added product
        productMap.put("P005", "Updated Product 5");


        // Write to file
        try {
            CreateFile();
            FileWriter myWriter = new FileWriter("D:\\New folder\\Project1\\Project1\\src\\resources\\Products-output.txt");
            for (Object code : productMap.keySet()) {
                String name = (String) productMap.get(code);

                String output = code + " | " + name;
                WriteToFile(output, myWriter);
            }
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
