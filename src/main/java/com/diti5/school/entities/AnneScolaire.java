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
public class AnneScolaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dateDebut;
    private String dateFin;
    @OneToMany(mappedBy = "anneScolaire")
    private List<Classe> classes = new ArrayList<Classe>();
    @ManyToMany(mappedBy = "")
    private List<Eleve> eleves = new ArrayList<Eleve>();
}
