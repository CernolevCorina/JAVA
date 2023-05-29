package basic;

import java.util.Scanner;

public class BidimensionalArray {
    public static void readArray(int[] array, Integer n, Scanner scanner) {
        for(int i=0; i<n; i++) {
            System.out.print("Enter item number "+ (i+1) + ": ");
            array[i] = scanner.nextInt();
        }
    }

    static int findCountOfDivisors(int number) {
        int result = 0;
        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                result++;
            }
        }
        return result;
    }

    static void findDivisors(int n, int[][] array, int index)
    {
        int divisorsCount = findCountOfDivisors(n);
        array[index] = new int[divisorsCount + 1];
        array[index][0] = n;
        int divisorsNumber = 1;
        for (int i=2;i<=n/2;i++)
            if (n%i==0){
                array[index][divisorsNumber] = i;
                divisorsNumber++;
            }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Enter array length: ");
        n = scanner.nextInt();
        int[] array = new int[n];
        readArray(array, n, scanner);

        int[][] resultArray = new int[n][];

        for(int index=0; index<n; index++) {
            findDivisors(array[index], resultArray, index);
        }

        for (int i=0; i < n; i++){
            for (int j = 0; j<resultArray[i].length; j++ ){
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
