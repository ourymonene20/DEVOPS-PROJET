package com.diti5.school.dao;

import com.diti5.school.entities.EmploiTemps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmploiTemps extends JpaRepository<EmploiTemps, Integer> {

    @Query("SELECT em FROM EmploiTemps em where em.id=:id")
    EmploiTemps getById(@Param("id") int id);
}
