package com.kakolats.springdatajpaonetooneproject.service;

import com.kakolats.springdatajpaonetooneproject.domaine.Encadreur;
import com.kakolats.springdatajpaonetooneproject.domaine.Etudiant;
import com.kakolats.springdatajpaonetooneproject.repository.EncadreurRepository;
import com.kakolats.springdatajpaonetooneproject.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EncadreurRepository encadRepository;

    @Autowired
    private EtudiantRepository etuRepository;

    //CRUD ETUDIANT
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etuRepository.save(etudiant);
    }

    public void deleteEtudiant(Etudiant etudiant) {
        Etudiant etu = etuRepository.findByNumero(etudiant.getNumero());
        if (etu != null) {
            Encadreur encad = etu.getEncadreur();
            if (encad != null) {
                encad.setEtudiant(null);
                encadRepository.save(encad);
            }
            etuRepository.delete(etu);
        } else {
            System.out.println("Etudiant introuvable");
        }
    }

    public void updateEtudiant(Etudiant etudiant) {
        Etudiant etu = etuRepository.findByNumero(etudiant.getNumero());
        if (etu != null) {
            etu.setNom(etudiant.getNom());
            etu.setPrenom(etudiant.getPrenom());
            if (etudiant.getEncadreur() != null) {
                etu.setEncadreur(etudiant.getEncadreur());
            }
            etuRepository.save(etu);
        } else {
            System.out.println("Etudiant introuvable");
        }
    }

    public void delete(Integer id) {
        etuRepository.deleteById(id);
    }

    public Etudiant affectEncadeur(Integer etudiant, Encadreur encadreur) {
        Etudiant etu = etuRepository.findByNumero(etudiant);
        if (etu != null) {
            etu.setEncadreur(encadreur);
            etuRepository.save(etu);
            return etu;
        } else {
            System.out.println("Etudiant introuvable");
        }
        return null;
    }

    public Etudiant desaffectEncadeur(Integer etudiant) {
        Etudiant etu = etuRepository.findByNumero(etudiant);
        if (etu != null) {
            etu.setEncadreur(null);
            etuRepository.save(etu);
            return etu;
        } else {
            System.out.println("Etudiant introuvable");
        }
        return null;
    }

    public List<Etudiant> getAllEtudiant() {
        return etuRepository.findAll();
    }

    public Etudiant rechercherEtudiant(Integer numero) {
        return etuRepository.findByNumero(numero);
    }


    public List<Etudiant> getAllEtudiantWithNoEncadreur() {
        return etuRepository.findAllEtudiantWithNoEncadreur();
    }
}
