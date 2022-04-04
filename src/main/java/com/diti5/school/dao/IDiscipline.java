package com.diti5.school.dao;

import com.diti5.school.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IDiscipline extends JpaRepository<Discipline, Integer> {

    @Query("SELECT * FROM Discipline ")
    Discipline getById(@Param("id") int id);
}

