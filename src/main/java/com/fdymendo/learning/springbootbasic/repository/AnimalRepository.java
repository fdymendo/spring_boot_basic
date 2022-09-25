package com.fdymendo.learning.springbootbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fdymendo.learning.springbootbasic.entities.AnimalEntity;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {

}
