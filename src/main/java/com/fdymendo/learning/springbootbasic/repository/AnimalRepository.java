package com.fdymendo.learning.springbootbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fdymendo.learning.springbootbasic.entities.AnimalEntity;

/**
 * @Repository it's an annotation that marks a class that will have the repository finality.
 */

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {

}
