package com.kakolats.springdatajpaonetooneproject.repository;

import com.kakolats.springdatajpaonetooneproject.domaine.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    public Etudiant findByNumero(Integer numero);

    @Query("select e from Etudiant e where e.encadreur is null")
    List<Etudiant> findAllEtudiantWithNoEncadreur();
}
