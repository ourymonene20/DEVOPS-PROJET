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
public class Controle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    private String dateControle;
    private String duree;
    private String periode;
    @ManyToMany(mappedBy = "controles")
    private List<Eleve> eleves = new ArrayList<Eleve>();
    @ManyToOne
    private Discipline discipline;
}
