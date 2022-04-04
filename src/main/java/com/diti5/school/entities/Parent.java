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
public class Parent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String lieuNaissance;
    private String cni;
    private String type_parite;
    private String tel;
    private String adresse;
    @ManyToMany
    private List<Eleve> eleves = new ArrayList<Eleve>();
}
