package oop;

import java.util.Scanner;

class Persoana {
    protected String nume;
    protected String adresa;
    protected String telefon;

    public Persoana(String nume, String adresa, String telefon) {
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }
}

class Client extends Persoana {
    private double suma;

    public Client(String nume, String adresa, String telefon, double suma) {
        super(nume, adresa, telefon);
        this.suma = suma;
    }

    public double acCredit() {
        return 1;
    }
}

class Angajat extends Persoana {
    public Angajat(String nume, String adresa, String telefon) {
        super(nume, adresa, telefon);
    }

    public double acCredit() {
        return -1;
    }
}

public class Lucratori {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numarul de persoane: ");
        int n = scanner.nextInt();

        Persoana[] persoane = new Persoana[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Introduceti tipul persoanei (1 - Client, 2 - Angajat): ");
            int tipPersoana = scanner.nextInt();

            System.out.print("Introduceti numele: ");
            String nume = scanner.next();
            System.out.print("Introduceti adresa: ");
            String adresa = scanner.next();
            System.out.print("Introduceti telefonul: ");
            String telefon = scanner.next();

            if (tipPersoana == 1) {
                System.out.print("Introduceti suma: ");
                double suma = scanner.nextDouble();
                persoane[i] = new Client(nume, adresa, telefon, suma);
            } else if (tipPersoana == 2) {
                persoane[i] = new Angajat(nume, adresa, telefon);
            }
        }

        boolean totiClientiiDeserviti = true;

        for (Persoana persoana : persoane) {
            if (persoana instanceof Client) {
                Client client = (Client) persoana;
                if (client.acCredit() != -1) {
                    totiClientiiDeserviti = false;
                    break;
                }
            }
        }

        if (totiClientiiDeserviti) {
            System.out.println("Toti clientii din sala sunt deserviti.");
        } else {
            System.out.println("Nu toti clientii din sala sunt deserviti.");
        }

        scanner.close();
    }
}

