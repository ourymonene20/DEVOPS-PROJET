package com.diti5.school.dao;

import com.diti5.school.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatiere extends JpaRepository<Matiere, Integer> {
}
