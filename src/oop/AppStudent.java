package oop;

import java.time.LocalDate;
import java.util.Scanner;

public class AppStudent {
    public static Student createStudent() {
        Scanner scanner = new Scanner(System.in);

        Student student = new Student();
        System.out.println("Enter student name: ");
        String nume=scanner.nextLine();
        student.setNume(nume);

        System.out.println("Enter student surname: ");
        student.setPrenume(scanner.nextLine());

        System.out.println("Enter student birthdate: ");
        student.setBirthdate(LocalDate.parse(scanner.nextLine()));

        System.out.println("Enter student hobby: ");
        student.setHobby(scanner.nextLine());

        return student;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Enter number of students in class: ");
        n = scanner.nextInt();
        Student[] arrayStudents = new Student[n];

        for (int i=0; i<=n; i++){
            arrayStudents[i] = createStudent();
        }
    }
}
