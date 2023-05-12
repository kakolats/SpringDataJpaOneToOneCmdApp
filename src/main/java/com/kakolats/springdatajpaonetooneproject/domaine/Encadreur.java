package com.kakolats.springdatajpaonetooneproject.domaine;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class Encadreur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numero;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 255)
    private String fonction;

    @OneToOne(mappedBy = "encadreur", cascade = CascadeType.ALL)
    private Etudiant etudiant;

    public Encadreur() {
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

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        String value  = "Encadreur{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", fonction='" + fonction + '\''+
                '}';
        if (etudiant != null)
            value += ", etudiant=" + etudiant.afficher();
        return value;

    }
     public String afficher() {
         return "Encadreur{" +
             "numero=" + numero +
             ", nom='" + nom + '\'' +
             ", prenom='" + prenom + '\'' +'}';
     }
}
