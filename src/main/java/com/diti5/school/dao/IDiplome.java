package com.diti5.school.dao;

import com.diti5.school.entities.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiplome extends JpaRepository<Diplome, Integer> {

    @Query("SELECT di FROM Diplome di where di.id=:id")
    Diplome getById(@Param("id") int id);
}
