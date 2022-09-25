package com.fdymendo.learning.springbootbasic.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fdymendo.learning.springbootbasic.dto.AnimalDTO;
import com.fdymendo.learning.springbootbasic.handlers.ApplicationException;
import com.fdymendo.learning.springbootbasic.model.ResponseDefault;
import com.fdymendo.learning.springbootbasic.service.IAnimalService;


@RestController
@RequestMapping(path = "/animals/v1")
public class AnimalController extends ACrudControllerTemplate<IAnimalService, AnimalDTO> {


  public AnimalController(IAnimalService service) {
    super(service);
  }

  @Override
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  protected ResponseEntity<ResponseDefault> save(@RequestBody AnimalDTO animalDTO) {
    return this.service.saveItem(animalDTO);
  }

  @Override
  @DeleteMapping(path = "/{id}")
  protected ResponseEntity<ResponseDefault> deleteById(@PathVariable int id) {
    return this.service.deleteItem(id);
  }

  @Override
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  protected ResponseEntity<ResponseDefault> findAll() {
    return this.service.getAllItems();
  }

  @Override
  @GetMapping(path = "/animal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  protected ResponseEntity<ResponseDefault> findById(@PathVariable int id) {
    return this.service.getItem(id);
  }

  @Override
  @PutMapping(path = "/animal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  protected ResponseEntity<ResponseDefault> update(@RequestBody AnimalDTO animalDTO,
      @PathVariable int id) throws ApplicationException {
    return this.service.updateItem(animalDTO, id);
  }


}
