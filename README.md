# Student Management System (Java + JDBC + MySQL)

Ce projet est une application Java console qui permet de gérer des étudiants, des cours et leurs inscriptions en utilisant JDBC et MySQL.

## Technologies utilisées

- Java (JDK 8 ou plus)
- Maven
- MySQL
- JDBC (mysql-connector)
- Git / GitHub

## Base de données

Créer une base de données nommée :

```sql
CREATE DATABASE gestion_etudiants;
USE gestion_etudiants;



Créer la table des étudiants :

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);
Créer la table des cours :

CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100)
);
Créer la table d'inscription :

CREATE TABLE enrollment (
    student_id INT,
    course_id INT
);
//Configuration

Vérifier les informations de connexion dans la classe DBConnection :

private static final String URL = "jdbc:mysql://localhost:3306/gestion_etudiants";
private static final String USER = "root";
private static final String PASSWORD = "";
//lancer le projet 
mvn clean compile exec:java
  
//Fonctionnalités principales

Ajouter un étudiant

Lister les étudiants

Ajouter un cours

Lister les cours

Inscrire un étudiant à un cours

Voir les cours d’un étudiant

Supprimer un étudiant
