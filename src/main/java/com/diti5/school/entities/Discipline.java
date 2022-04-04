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
public class Discipline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    @OneToMany(mappedBy = "discipline")
    private List<Controle> controles = new ArrayList<Controle>();
    @OneToMany(mappedBy = "discipline")
    private List<Matiere> matieres = new ArrayList<Matiere>();
    @ManyToMany
    private List<Niveau> niveaus = new ArrayList<Niveau>();
}
