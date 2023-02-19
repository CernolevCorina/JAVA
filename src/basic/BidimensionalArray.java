package basic;

import java.util.Scanner;

public class BidimensionalArray {
    public static void readArray(int[][] array, Integer n, Scanner scanner) {
        for(int i=0; i<n; i++) {
            System.out.print("Enter item number "+ (i+1) + ": ");
            array[i][0] = scanner.nextInt();
        }
    }
    static void findAndPrintDivisors(int n)
    {
        for (int i=1;i<=n;i++)
            if (n%i==0)
                System.out.printf("%d ",i);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Enter array length: ");
        n = scanner.nextInt();
        int[][] array = new int[n][n];
        readArray(array, n, scanner);

        for(int i=0; i<n; i++) {
            findAndPrintDivisors(array[i][0]);
        }
    }
}
