package com.diti5.school.dao;

import com.diti5.school.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParent extends JpaRepository<Parent, Integer> {
}
