package com.diti5.school.dao;

import com.diti5.school.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProfesseur extends JpaRepository<Professeur, Integer> {

    @Query("SELECT pr FROM Professeur pr where pr.id=:id")
    Professeur getById(@Param("id") int id);

    @Query("SELECT pr FROM Professeur pr where pr.prenom=:prenom")
    Professeur getByPrenom(@Param("prenom") String prenom);
}
