package oop;

import java.util.Scanner;

public class Cerc {
    private double raza;

    public Cerc(double raza) {
        this.raza = raza;
    }

    public double calcAria() {
        return Math.PI * Math.pow(raza, 2);
    }

    public double calcLungime() {
        return 2 * Math.PI * raza;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numarul de cercuri: ");
        int n = scanner.nextInt();

        Cerc[] cercuri = new Cerc[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Introduceti raza pentru cercul " + (i + 1) + ": ");
            double raza = scanner.nextDouble();
            cercuri[i] = new Cerc(raza);
        }

        double ariaTotala = 0;
        double lungimeTotala = 0;

        for (Cerc cerc : cercuri) {
            ariaTotala += cerc.calcAria();
            lungimeTotala += cerc.calcLungime();
        }

        System.out.println("Aria totala a celor " + n + " cercuri: " + ariaTotala);
        System.out.println("Lungimea totala a celor " + n + " cercuri: " + lungimeTotala);

        scanner.close();
    }
}
