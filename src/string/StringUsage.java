package string;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;

public class StringUsage {
    public static void CreateFile() {
        try {
            File myObj = new File("D:\\New folder\\Project1\\Project1\\src\\resources\\output.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static String ReadString() {
        try {
            File myObj = new File("D:\\New folder\\Project1\\Project1\\src\\resources\\input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                return myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
    public static void WriteToFile(String phrase) {
        CreateFile();

        try {
            FileWriter myWriter = new FileWriter("D:\\New folder\\Project1\\Project1\\src\\resources\\output.txt");
            myWriter.write(phrase);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static String ToUppercase(String phrase) {
        return phrase.toUpperCase();
    }
    private static String ToLowerCase(String phrase) {
        return phrase.toLowerCase();
    }
    private static Integer StringLength(String phrase) {
        return phrase.length();
    }
    private static void CountVowelConsonant (String phrase) {
        int consonants = 0, vowels = 0;
        String str = ToLowerCase(phrase);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                vowels++;
            }
            else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                consonants++;
            }
        }

        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
    }
    private static Integer CountWords(String phrase) {
        String[] words = phrase.split("\\s+");
        return words.length;
    }
    public static String lengthiestString(String phrase) {
        return Arrays.stream(phrase.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null);
    }
    public static String shortiestString(String phrase) {
        return Arrays.stream(phrase.split(" ")).min(Comparator.comparingInt(String::length)).orElse(null);
    }
    public static void FindDublicates(String phrase) {
        String[] words = phrase.split("\\W");
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 1; j < words.length; j++) {
                if (words[i].equals(words[j]) && i != j) {
                    set.add(words[i]);
                }
            }
        }
        System.out.println("Dublicates: " + set);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phrase = ReadString();
        int option;
        System.out.println("Initial phrase: " + phrase);

        do {
            System.out.println("Menu: ");
            System.out.println("1. Phrase to upper case;");
            System.out.println("2. Phrase to lower case;");
            System.out.println("3. Determine phrase length;");
            System.out.println("4. Count the consonants and vowels in phrase;");
            System.out.println("5. Count the number of words in phrase;");
            System.out.println("6. Find the word having maximum length in the phrase;");
            System.out.println("7. Find the word having minimum length in the phrase;");
            System.out.println("8. Find dublicates;");
            System.out.println("0. Exit.");
            System.out.println("Please choose an option:");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    phrase = ToUppercase(phrase);
                    WriteToFile(phrase);
                }
                case 2 -> {
                    phrase = ToLowerCase(phrase);
                    WriteToFile(phrase);
                }
                case 3 -> {
                    Integer length = StringLength(phrase);
                    System.out.println("Phrase length: " + length);
                }
                case 4 -> {
                    System.out.println("Phrase : " + phrase);
                    CountVowelConsonant(phrase);
                }
                case 5 -> {
                    Integer wordsNumber = CountWords(phrase);
                    System.out.println("Phrase : " + phrase);
                    System.out.println("In this phrase we have " + wordsNumber + " words");
                }
                case 6 -> {
                    System.out.println("Maximum length word : " + lengthiestString(phrase));
                }
                case 7 -> {
                    System.out.println("Minimum length word : " + shortiestString(phrase));
                }
                case 8 -> {
                    FindDublicates(phrase);
                }
            }
        }while (option != 0);
    }
}
