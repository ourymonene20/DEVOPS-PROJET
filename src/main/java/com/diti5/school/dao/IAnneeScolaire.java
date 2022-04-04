package com.diti5.school.dao;


import com.diti5.school.entities.AnneScolaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnneeScolaire extends JpaRepository<AnneScolaire, Integer> {

    @Query("SELECT an FROM AnneScolaire an where an.id=:id")
    AnneScolaire getById(@Param("id") int id);
}
