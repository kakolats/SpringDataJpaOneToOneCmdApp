package com.kakolats.springdatajpaonetooneproject.service;

import com.kakolats.springdatajpaonetooneproject.domaine.Encadreur;
import com.kakolats.springdatajpaonetooneproject.domaine.Etudiant;
import com.kakolats.springdatajpaonetooneproject.repository.EncadreurRepository;
import com.kakolats.springdatajpaonetooneproject.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtudiantService {
    @Autowired
    private EncadreurRepository encadRepository;

    @Autowired
    private EtudiantRepository etuRepository;

    //CRUD ETUDIANT
    public void createEtudiant(Etudiant etudiant){
        etuRepository.save(etudiant);
    }
    public void deleteEtudiant(Integer numero){
        Etudiant etu = etuRepository.findByNumero(numero);
        if (etu != null){
            if(etu.getEncadreur() != null){
                Encadreur enc = etu.getEncadreur();
                enc.setEtudiant(null);
                encadRepository.save(enc);
            }
            etuRepository.delete(etu);
        }else {
            System.out.println("Etudiant introuvable");
        }
    }
    public void updateEtudiant(Etudiant etudiant){
        Etudiant etu = etuRepository.findByNumero(etudiant.getNumero());
        if (etu != null){
            etu.setNom(etudiant.getNom());
            etu.setPrenom(etudiant.getPrenom());
            if(etudiant.getEncadreur() != null){
                etu.setEncadreur(etudiant.getEncadreur());
            }
            etuRepository.save(etu);
        }else {
            System.out.println("Etudiant introuvable");
        }
    }
}
