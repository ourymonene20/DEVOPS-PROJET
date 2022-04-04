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
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    @ManyToOne
    private AnneScolaire anneScolaire;
    @OneToMany(mappedBy = "classe")
    private List<Eleve> eleves = new ArrayList<Eleve>();
    @ManyToOne
    private Niveau niveau;
    @ManyToOne
    private EmploiTemps emploiTemps;
}
