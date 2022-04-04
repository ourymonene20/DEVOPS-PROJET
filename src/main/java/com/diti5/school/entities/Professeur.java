package com.diti5.school.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professeur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String dateNaissance;
    private String lieuNaissance;
    private String tel;
    private String adresse;
    @OneToMany(mappedBy = "professeur")
    private List<EmploiTemps> emploiTemps = new ArrayList<EmploiTemps>();
}
