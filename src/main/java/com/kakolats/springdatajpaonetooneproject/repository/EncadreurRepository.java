package com.kakolats.springdatajpaonetooneproject.repository;

import com.kakolats.springdatajpaonetooneproject.domaine.Encadreur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncadreurRepository extends JpaRepository<Encadreur,Integer> {

    public Encadreur findByNumero(Integer numero);
}
