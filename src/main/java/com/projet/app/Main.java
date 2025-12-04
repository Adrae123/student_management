package com.projet.app;

import com.projet.model.*;
import com.projet.service.UniversityService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UniversityService service = new UniversityService();

        while(true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Lister les étudiants");
            System.out.println("2 - Ajouter un étudiant");
            System.out.println("3 - Lister les cours");
            System.out.println("4 - Ajouter un cours");
            System.out.println("5 - Inscrire un étudiant");
            System.out.println("6 - Lister les cours d'un étudiant");
            System.out.println("7 - Supprimer un étudiant");
            System.out.println("0 - Quitter");
            System.out.print("Choix: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consommer \n

            switch(choice) {
                case 1:
                    List<Student> students = service.getAllStudents();
                    students.forEach(s -> System.out.println(s.getName() + " - " + s.getEmail()));
                    break;
                case 2:
                    System.out.print("Nom: "); String name = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    service.addStudent(new Student(name, email));
                    break;
                case 3:
                    List<Course> courses = service.getAllCourses();
                    courses.forEach(c -> System.out.println(c.getTitle()));
                    break;
                case 4:
                    System.out.print("Titre du cours: "); String title = sc.nextLine();
                    service.addCourse(new Course(title));
                    break;
                case 5:
                    System.out.print("ID étudiant: "); int sid = sc.nextInt();
                    System.out.print("ID cours: "); int cid = sc.nextInt();
                    service.enrollStudentToCourse(sid, cid);
                    break;
                case 6:
                    System.out.print("ID étudiant: "); int sid2 = sc.nextInt();
                    List<Course> studentCourses = service.getCoursesByStudent(sid2);
                    studentCourses.forEach(c -> System.out.println(c.getTitle()));
                    break;
                case 7:
                    System.out.print("ID étudiant à supprimer: "); int sid3 = sc.nextInt();
                    service.deleteStudent(sid3);
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
