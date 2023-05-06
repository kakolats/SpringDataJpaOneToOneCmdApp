package com.kakolats.springdatajpaonetooneproject.repository;

import com.kakolats.springdatajpaonetooneproject.domaine.Encadreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EncadreurRepository extends JpaRepository<Encadreur,Integer> {

    public Encadreur findByNumero(Integer numero);

    @Query("select e from Encadreur e where e.etudiant is null")
    List<Encadreur> findAllByEtudiantIsNull();
}
