package com.diti5.school.dao;

import com.diti5.school.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClasse extends JpaRepository<Classe, Integer> {

    @Query("SELECT cl FROM Classe cl where cl.id=:id")
    Classe getById(@Param("id") int id);
}
