package basic;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scannerVar = new Scanner(System.in);

        System.out.println("Please, give two numbers");
        int firstNumber = scannerVar.nextInt();
        int secondNumber = scannerVar.nextInt();

        System.out.println("Please, give operation");
        char op = scannerVar.next().charAt(0);

        double result = 0;

        switch (op) {
            case '+' -> {
                result = firstNumber + secondNumber;
                break;
            }
            case ':', '/' -> {
                result = (double) (firstNumber) / secondNumber;
                break;
            }
            case '-' -> {
                result = firstNumber - secondNumber;
                break;
            }
            case '*' -> {
                result = firstNumber * secondNumber;
                break;
            }
            default -> {
                System.out.println("Unknown operator");
            }
        }

        System.out.println("Result: " + result);
    }
}
