package oop;

class Device {
    public Device() {
        System.out.print("D");
    }
}

public class  Evaluare extends Device {
        public Evaluare() {
            System.out.print("W");
        }

        public Evaluare(String name) {
            this();
            System.out.print(name);
        }

        public static void main(String[] args) {
            new Evaluare("F");
        }
}
