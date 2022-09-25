package com.fdymendo.learning.springbootbasic.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ACrudServiceTemplate<T extends JpaRepository<S, Integer>, S> {

  protected T repository;

  public ACrudServiceTemplate(T repository) {
    this.repository = repository;
  }

  public void save(S item) {
    repository.save(item);
  }

  public void deleteById(int id) {
    repository.deleteById(id);
  }

  public List<S> findAll() {
    return repository.findAll();
  }

  public S findById(int id) {
    return repository.findById(id).orElseThrow();
  }

}
