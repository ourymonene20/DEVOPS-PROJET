package com.diti5.school.dao;

import com.diti5.school.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface INiveau extends JpaRepository<Niveau, Integer> {

    @Query("SELECT n FROM Niveau n where n.id=:id")
    Niveau getById(@Param("id") int id);
}
