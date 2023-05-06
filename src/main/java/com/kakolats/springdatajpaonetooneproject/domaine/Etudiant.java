package com.kakolats.springdatajpaonetooneproject.domaine;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero", nullable = false, unique = true)
    private Integer numero;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 50)
    private String theme;

    @OneToOne
    @JoinColumn(name = "encadreur", referencedColumnName = "numero", nullable = true)
    private Encadreur encadreur;

    public Etudiant() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Encadreur getEncadreur() {
        return encadreur;
    }

    public void setEncadreur(Encadreur encadreur) {
        this.encadreur = encadreur;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", theme='" + theme + '\'' +
                ", encadreur=" + encadreur +
                '}';
    }

    public void afficher() {
        System.out.println("Etudiant{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", theme='" + theme + '\'' +
                ", encadreur=" + encadreur +
                '}');
    }
}
