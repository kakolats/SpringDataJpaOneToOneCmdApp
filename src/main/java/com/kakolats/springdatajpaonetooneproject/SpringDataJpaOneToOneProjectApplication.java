package com.kakolats.springdatajpaonetooneproject;

import com.kakolats.springdatajpaonetooneproject.domaine.Encadreur;
import com.kakolats.springdatajpaonetooneproject.domaine.Etudiant;
import com.kakolats.springdatajpaonetooneproject.service.EncadreurService;
import com.kakolats.springdatajpaonetooneproject.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaOneToOneProjectApplication implements CommandLineRunner {

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
            System.out.println("5-Voir tous les étudiants");
            System.out.println("6-Créer un encadreur");
            System.out.println("7-Modifier un encadreur");
            System.out.println("8-Supprimer un encadreur");
            System.out.println("9-Affecter un encadreur à un étudiant");
            System.out.println("10-Déssafecter un étudiant et un encadreur");
            System.out.println("11-Voir la liste des encadreurs non affectés");
            System.out.println("12-Voir tous les encadreurs");
            System.out.println("13-Quitter");
            choix = getIntegerInput(sc);
            sc.nextLine();
            switch (choix) {
                case 1:
                    Etudiant etudiant = createEtudiant(sc);
                    etudiant = etuService.createEtudiant(etudiant);
                    System.out.println("Etudiant créé avec succès");
                    etudiant.afficher();
                    break;
                case 2:
                    System.out.println("Liste des étudiants");
                    etuService.getAllEtudiant().forEach(System.out::println);
                    System.out.println("Veuillez entrer le numéro de l'étudiant à modifier");
                    int numero = getIntegerInput(sc);
                    Etudiant etudiant1 = etuService.rechercherEtudiant(numero);
                    if (etudiant1 != null) {
                        Etudiant etudToUpdate = editEtudiant(sc, etudiant1);
                        //etuService.updateEtudiant(etudiant1);
                    } else {
                        System.out.println("Aucun étudiant trouvé avec ce numéro");
                    }
                    break;
                case 3:
                    System.out.println("Liste des étudiants");
                    etuService.getAllEtudiant().forEach(System.out::println);
                    System.out.println("Veuillez entrer le numéro de l'étudiant à supprimer");
                    int numero1 = getIntegerInput(sc);
                    Etudiant etudiant2 = etuService.rechercherEtudiant(numero1);
                    if (etudiant2 != null) {
                        etuService.deleteEtudiant(etudiant2);
                    } else {
                        System.out.println("Aucun étudiant trouvé avec ce numéro");
                    }
                    break;
                case 4:
                    System.out.println("Liste des étudiants");
                    etuService.getAllEtudiant().forEach(System.out::println);
                    System.out.println("Veuillez entrer le numéro de l'étudiant");
                    int numero2 = getIntegerInput(sc);
                    Etudiant etudiant3 = etuService.rechercherEtudiant(numero2);
                    if (etudiant3 != null) {
                        System.out.println("Liste des encadreurs non affectés");
                        this.encadService.getAllEncadreursWithNoEtudiant().forEach(System.out::println);
                        System.out.println("Veuillez entrer le numéro de l'encadreur");
                        int numero3 = getIntegerInput(sc);
                        Encadreur encadreur = encadService.rechercherEncadreur(numero3);
                        if (encadreur != null) {
                            etudiant3.setEncadreur(encadreur);
                            etuService.updateEtudiant(etudiant3);
                        } else {
                            System.out.println("Aucun encadreur trouvé avec ce numéro");
                        }
                    } else {
                        System.out.println("Aucun étudiant trouvé avec ce numéro");
                    }
                    break;
                case 5:
                    etuService.getAllEtudiant().forEach(System.out::println);
                    break;
                case 6:
                    Encadreur encadreur = createEncadreur(sc);
                    encadreur = encadService.createEncadreur(encadreur);
                    System.out.println("Encadreur créé avec succès");
                    encadreur.toString();
                    break;
                case 7:
                    System.out.println("Liste des encadreurs");
                    encadService.getAllEncadreurs().forEach(System.out::println);
                    System.out.println("Veuillez entrer le numéro de l'encadreur à modifier");
                    int numero4 = getIntegerInput(sc);
                    Encadreur encadreur1 = encadService.rechercherEncadreur(numero4);
                    if (encadreur1 != null) {
                        Encadreur encadToUpdate = editEncadreur(sc, encadreur1);
                        encadreur1 = encadService.updateEncadreur(encadToUpdate);
                        System.out.println("Encadreur modifié avec succès");
                        encadreur1.toString();
                    } else {
                        System.out.println("Aucun encadreur trouvé avec ce numéro");
                    }
                    break;
                case 8:
                    System.out.println("Liste des encadreurs");
                    encadService.getAllEncadreurs().forEach(System.out::println);
                    System.out.println("Veuillez entrer le numéro de l'encadreur à supprimer");
                    int numero5 = getIntegerInput(sc);
                    Encadreur encadreur2 = encadService.rechercherEncadreur(numero5);
                    if (encadreur2 != null) {
                        encadService.deleteEncadreur(encadreur2.getNumero());
                    } else {
                        System.out.println("Aucun encadreur trouvé avec ce numéro");
                    }
                    break;
                case 9:
                    System.out.println("Liste des encadreurs");
                    encadService.getAllEncadreurs().forEach(System.out::println);
                    System.out.println("Veuillez entrer le numéro de l'encadreur");
                    int numero6 = getIntegerInput(sc);
                    Encadreur encadreur3 = encadService.rechercherEncadreur(numero6);
                    if (encadreur3 != null) {
                        System.out.println("Liste des étudiants non affectés");
                        this.etuService.getAllEtudiantWithNoEncadreur().forEach(System.out::println);
                        System.out.println("Veuillez entrer le numéro de l'étudiant");
                        int numero7 = getIntegerInput(sc);
                        Etudiant etudiant4 = etuService.rechercherEtudiant(numero7);
                        if (etudiant4 != null) {
                            encadreur3.setEtudiant(etudiant4);
                            encadService.updateEncadreur(encadreur3);
                        } else {
                            System.out.println("Aucun étudiant trouvé avec ce numéro");
                        }
                    } else {
                        System.out.println("Aucun encadreur trouvé avec ce numéro");
                    }
                    break;
                case 10:
                    //10- Déssafecter un étudiant et un encadreur
                    System.out.println("Liste des encadreurs");
                    encadService.getAllEncadreursWithEtudiant().forEach(System.out::println);
                    System.out.println("Veuillez entrer le numéro de l'encadreur");
                    int numero8 = getIntegerInput(sc);
                    Encadreur encadreur4 = encadService.rechercherEncadreur(numero8);
                    if (encadreur4 != null) {
                        encadreur4.setEtudiant(null);
                        encadService.updateEncadreur(encadreur4);
                    } else {
                        System.out.println("Aucun encadreur trouvé avec ce numéro");
                    }
                    break;
                case 11:
                    //11- Voir la liste des encadreurs non affectés
                    System.out.println("Liste des encadreurs non affectés");
                    encadService.getAllEncadreursWithNoEtudiant().forEach(System.out::println);
                    break;
                case 12:
                    //12- Voir tous les encadreurs
                    System.out.println("Liste des encadreurs");
                    encadService.getAllEncadreurs().forEach(System.out::println);
                    break;
            }
        } while (choix != 13);
    }


    public static int getIntegerInput(Scanner sc) {
        while (true) {
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
        while (true) {
            try {
                double input = sc.nextDouble();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Valeur invalide... Veuillez entrer un décimal");
                sc.next();
            }
        }
    }

    public static String getStringInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Valeur invalide... Veuillez entrer une chaîne de caractères");
                sc.next();
            }
        }
    }

    private static Etudiant createEtudiant(Scanner sc) {
        System.out.println("Veuillez entrer le nom de l'étudiant : ");
        String nom = getStringInput(sc);
        System.out.println("Veuillez entrer le prénom de l'étudiant : ");
        String prenom = getStringInput(sc);
        System.out.println("Veuillez entrer le thème de l'étudiant : ");
        String theme = getStringInput(sc);
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setTheme(theme);
        return etudiant;
    }

    private static Etudiant editEtudiant(Scanner sc, Etudiant etudiant1) {
        System.out.println("Veuillez entrer le nouveau nom");
        String name = getStringInput(sc);
        System.out.println("Veuillez entrer le nouveau prénom");
        String prenom = getStringInput(sc);
        System.out.println("Veuillez entrer le nouveau thème");
        String theme = getStringInput(sc);
        etudiant1.setNom(name);
        etudiant1.setPrenom(prenom);
        etudiant1.setTheme(theme);
        return etudiant1;
    }

    private static Encadreur createEncadreur(Scanner sc) {
        System.out.println("Veuillez entrer le nom de l'encadreur : ");
        String nom = getStringInput(sc);
        System.out.println("Veuillez entrer le prénom de l'encadreur : ");
        String prenom = getStringInput(sc);
        System.out.println("Veuillez entrer la fonction de l'encadreur : ");
        String grade = getStringInput(sc);
        Encadreur encadreur = new Encadreur();
        encadreur.setNom(nom);
        encadreur.setPrenom(prenom);
        encadreur.setFonction(grade);
        return encadreur;
    }

    private static Encadreur editEncadreur(Scanner sc, Encadreur encadreur) {
        System.out.println("Veuillez entrer le nouveau nom");
        String name = getStringInput(sc);
        System.out.println("Veuillez entrer le nouveau prénom");
        String prenom = getStringInput(sc);
        System.out.println("Veuillez entrer la nouvelle fonction");
        String grade = getStringInput(sc);
        encadreur.setNom(name);
        encadreur.setPrenom(prenom);
        encadreur.setFonction(grade);
        return encadreur;
    }
}
