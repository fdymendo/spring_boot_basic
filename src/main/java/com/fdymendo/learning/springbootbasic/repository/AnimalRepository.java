package com.fdymendo.learning.springbootbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fdymendo.learning.springbootbasic.entities.AnimalEntity;

/**
 * The Repository annotation marks a class that serves as a repository, indicating that it will be used for data access and storage.
 */
@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {

}
