package com.kakolats.springdatajpaonetooneproject.repository;

import com.kakolats.springdatajpaonetooneproject.domaine.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    public Etudiant findByNumero(Integer numero);
}
