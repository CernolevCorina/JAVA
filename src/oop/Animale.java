package oop;
import java.util.Scanner;

class Animal {
    protected String nume;
    protected int varsta;

    public Animal(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    public void zice() {
        System.out.println("Sunetul emis de animal.");
    }
}

class Caine extends Animal {
    public Caine(String nume, int varsta) {
        super(nume, varsta);
    }

    @Override
    public void zice() {
        System.out.println("Ham! Ham!");
    }
}

class Pisica extends Animal {
    public Pisica(String nume, int varsta) {
        super(nume, varsta);
    }

    @Override
    public void zice() {
        System.out.println("Miau! Miau!");
    }
}

public class Animale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numele si varsta cainelui: ");
        String numeCaine = scanner.next();
        int varstaCaine = scanner.nextInt();
        Caine caine = new Caine(numeCaine, varstaCaine);

        System.out.print("Introduceti numele si varsta pisicii: ");
        String numePisica = scanner.next();
        int varstaPisica = scanner.nextInt();
        Pisica pisica = new Pisica(numePisica, varstaPisica);

        System.out.println("Cainele se numeste " + caine.nume + " si are varsta de " + caine.varsta + " ani.");
        caine.zice();

        System.out.println("Pisica se numeste " + pisica.nume + " si are varsta de " + pisica.varsta + " ani.");
        pisica.zice();

        scanner.close();
    }
}
