package com.kakolats.springdatajpaonetooneproject.service;


import com.kakolats.springdatajpaonetooneproject.domaine.Encadreur;
import com.kakolats.springdatajpaonetooneproject.domaine.Etudiant;
import com.kakolats.springdatajpaonetooneproject.repository.EncadreurRepository;
import com.kakolats.springdatajpaonetooneproject.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncadreurService {
    @Autowired
    private EncadreurRepository encadRepository;

    @Autowired
    private EtudiantRepository etuRepository;

    //CRUD ENCADREUR
    public Encadreur createEncadreur(Encadreur encadreur) {
        return encadRepository.save(encadreur);
    }

    public void deleteEncadreur(Integer numero) {
        Encadreur encad = encadRepository.findByNumero(numero);
        if (encad != null) {
            Etudiant etu = encad.getEtudiant();
            if (etu != null) {
                etu.setEncadreur(null);
                etuRepository.save(etu);
            }
            encad.setEtudiant(null);
            encadRepository.delete(encad);
        } else {
            System.out.println("Encadreur introuvable");
        }
    }

    public Encadreur updateEncadreur(Encadreur encadreur) {
        try {
            Encadreur encad = encadRepository.findByNumero(encadreur.getNumero());
            if (encad != null) {
                encad.setNom(encadreur.getNom());
                encad.setPrenom(encadreur.getPrenom());
                encad.setFonction(encadreur.getFonction());
                if (encadreur.getEtudiant() != null) {
                    encad.setEtudiant(encadreur.getEtudiant());
                }
                return encadRepository.save(encad);
            } else {
                System.out.println("Encadreur introuvable");
            }
        } catch (Exception e) {
            System.out.println("Encadreur introuvable");
        }
        return null;
    }

    public Encadreur rechercherEncadreur(Integer numero) {
        Encadreur encad = encadRepository.findByNumero(numero);
        return encad;
    }

    public List<Encadreur> rechercherTousEncadreur() {
        return encadRepository.findAll();
    }

    public List<Encadreur> getAllEncadreurs() {
        return encadRepository.findAll();
    }

    public List<Encadreur> getAllEncadreursWithNoEtudiant() {
        return encadRepository.findByEtudiantIsNull();
    }

    public List<Encadreur> getAllEncadreursWithEtudiant() {
        return encadRepository.findByEtudiantIsNotNull();
    }
}
