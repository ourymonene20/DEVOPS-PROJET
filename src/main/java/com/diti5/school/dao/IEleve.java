package com.diti5.school.dao;

import com.diti5.school.entities.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEleve extends JpaRepository<Eleve, Integer> {

    @Query("SELECT el FROM Eleve el where el.id=:id")
    Eleve getById(@Param("id") int id);

    @Query("SELECT el FROM Eleve el where el.prenom=:prenom")
    Eleve getByPrenom(@Param("prenom") String prenom);
}
