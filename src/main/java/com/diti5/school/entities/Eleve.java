package com.diti5.school.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Eleve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String lieuNaissance;
    private String sexe;
    @ManyToMany(mappedBy = "eleves")
    private List<Parent> parents = new ArrayList<Parent>();
    @OneToMany(mappedBy = "eleve")
    private List<AbsenceEleve> absenceEleves = new ArrayList<AbsenceEleve>();
    @ManyToOne
    private Classe classe;
    @ManyToMany
    private List<Controle> controles = new ArrayList<Controle>();

}
