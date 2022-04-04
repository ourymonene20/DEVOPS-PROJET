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
public class Niveau implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    private String option;
    @OneToMany(mappedBy = "niveau")
    private List<Classe> classes = new ArrayList<Classe>();
    @ManyToMany(mappedBy = "niveaus")
    private List<Discipline> disciplines = new ArrayList<Discipline>();
}
