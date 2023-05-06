package com.kakolats.springdatajpaonetooneproject;

import com.kakolats.springdatajpaonetooneproject.domaine.Encadreur;
import com.kakolats.springdatajpaonetooneproject.domaine.Etudiant;
import com.kakolats.springdatajpaonetooneproject.repository.EncadreurRepository;
import com.kakolats.springdatajpaonetooneproject.repository.EtudiantRepository;
import com.kakolats.springdatajpaonetooneproject.service.EncadreurService;
import com.kakolats.springdatajpaonetooneproject.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaOneToOneProjectApplication implements CommandLineRunner  {

    @Autowired
    private EncadreurService encadService;
    @Autowired
    private EtudiantService etuService;


    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaOneToOneProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        do {
            System.out.println("1-Créer un étudiant");
            System.out.println("2-Modifier un étudiant");
            System.out.println("3-Supprimer un étudiant");
            System.out.println("4-Affecter un encadreur à un étudiant");
            System.out.println("5-Affecter un encadreur à un étudiant");
            System.out.println("6-Voir tous les étudiants");
            System.out.println("7-Créer un encadreur");
            System.out.println("8-Modifier un encadreur");
            System.out.println("9-Supprimer un encadreur");
            System.out.println("10-Déssafecter un étudiant et un encadreur");
            System.out.println("11-Voir la liste des encadreurs non affectés");
            System.out.println("12-Voir tous les encadreurs");
            System.out.println("13-Quitter");
            choix = getIntegerInput(sc);
            sc.nextLine();
            switch (choix){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
            }
        }while (choix!=13);
    }

    public static int getIntegerInput(Scanner sc) {
        while(true) {
            try {
                int input = sc.nextInt();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Valeur invalide... Veuillez entrer un chiffre.");
                sc.next();
            }
        }
    }

    public static double getDoubleInput(Scanner sc) {
        while(true) {
            try {
                double input = sc.nextDouble();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Valeur invalide... Veuillez entrer un décimal");
                sc.next();
            }
        }
    }
}
