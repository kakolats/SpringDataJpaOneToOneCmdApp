package com.kakolats.springdatajpaonetooneproject;

import com.kakolats.springdatajpaonetooneproject.domaine.Encadreur;
import com.kakolats.springdatajpaonetooneproject.domaine.Etudiant;
import com.kakolats.springdatajpaonetooneproject.repository.EncadreurRepository;
import com.kakolats.springdatajpaonetooneproject.repository.EtudiantRepository;
import com.kakolats.springdatajpaonetooneproject.service.EncadreurService;
import com.kakolats.springdatajpaonetooneproject.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaOneToOneProjectApplication implements CommandLineRunner  {

    @Autowired
    private EncadreurService encadService;
    @Autowired
    private EtudiantService etuService;


    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaOneToOneProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }


}
