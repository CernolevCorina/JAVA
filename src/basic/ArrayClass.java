package basic;

import java.util.*;

public class ArrayClass {
    public static void readArray(Integer[] array, Integer n, Scanner scanner) {
        for(int i=0; i<n; i++) {
            System.out.print("Enter item number "+ (i+1) + ": ");
            array[i] = scanner.nextInt();
        }
    }

    public static boolean include(Integer[] array, Integer number) {
        return Arrays.asList(array).contains(number);
    }

    public static int maxValue(Integer[] array) {
        return Collections.min(Arrays.asList(array));
    }
    public static int minValue(Integer[] array) {
        return Collections.min(Arrays.asList(array));
    }

    public static void Frequency(Integer[] array) {
        List<Integer> asList = Arrays.asList(array);
        Set<Integer> mySet = new HashSet<Integer>(asList);

        for(Integer s: mySet){
            System.out.println(s + " " + Collections.frequency(asList,s));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Enter array length: ");
        n = scanner.nextInt();
        Integer[] array = new Integer[n];
        readArray(array, n, scanner);

        int option;

        do {
            System.out.println("Menu: ");
            System.out.println("1. Check if in array we have a number;");
            System.out.println("2. Calculate max/min;");
            System.out.println("3. Frequency of elements;");
            System.out.println("0. Exit.");
            System.out.println("Please choose an option;");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Enter a number, please: ");
                    int number;
                    number = scanner.nextInt();

                    if (include(array, number)) {
                        System.out.println("Array include entered number ");
                    } else {
                        System.out.println("Array not include entered number ");
                    }
                }
                case 2 -> {
                    int max = maxValue(array);
                    System.out.println("Max: " + max);
                    int min = minValue(array);
                    System.out.println("Min: " + min);
                }
                case 3 -> {
                    Frequency(array);
                }
            }
        }while (option != 0);

    }
}
