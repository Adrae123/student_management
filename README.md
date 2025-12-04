# Gestion des étudiants - Java / JDBC / Maven

Ce projet est une application Java utilisant JDBC et MySQL pour gérer des étudiants, des cours et leurs inscriptions.

La classe principale configurée dans Maven est :
com.projet.app.Main

Commande de lancement :
mvn clean compile exec:java


---


Base de données (à créer dans MySQL) :

CREATE DATABASE school_db;
USE school_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100)
);

CREATE TABLE enrollment (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id)
);


Dans la classe DBConnection.java, utiliser par exemple :

private static final String URL = "jdbc:mysql://localhost:3306/school_db";
private static final String USER = "root";
private static final String PASSWORD = "";


---


Fonctionnalités principales :

- Ajouter un étudiant
- Supprimer un étudiant
- Afficher tous les étudiants
- Ajouter des cours
- Inscrire un étudiant à un cours
- Afficher les cours d’un étudiant


---


Exemple d’utilisation dans Main :

Student student = new Student("Omar", "omar@gmail.com");
studentDao.addStudent(student);

List<Student> students = studentDao.getAllStudents();

for (Student s : students) {
    System.out.println(s.getId() + " - " + s.getName() + " - " + s.getEmail());
}


---


Dépendances utilisées :

- mysql-connector-java 8.0.33
- junit-jupiter 5.7.1
- exec-maven-plugin 3.6.2
- Java 8


---


Problèmes corrigés dans ce projet :

- List cannot be resolved to a type
- Conflit entre StudentDAO et StudentDao
- Mauvaise correspondance entre interface et implémentation
- Problèmes de connexion JDBC


---


Améliorations possibles plus tard :

- Ajouter une interface graphique (JavaFX / Swing)
- Convertir en API Spring Boot
- Ajouter des rôles (Admin / User)
- Ajouter la gestion des notes
