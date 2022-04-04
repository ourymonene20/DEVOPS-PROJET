package com.diti5.school.dao;

import com.diti5.school.entities.AbsenceEleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAbsenceEleve extends JpaRepository<AbsenceEleve, Integer> {

    @Query("SELECT al FROM AbsenceEleve al where al.id=:id")
    AbsenceEleve getById(@Param("id") int id);
}
