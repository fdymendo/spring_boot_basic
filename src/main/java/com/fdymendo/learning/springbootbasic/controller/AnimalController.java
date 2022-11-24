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


/**
 * @RestController It's a petition with an specific declared JSON format
 * @RequestMapping Annotation that relate a method with a http petition.
 *
 */
@RestController
@RequestMapping(path = "/animals/v1")
public class AnimalController extends ACrudControllerTemplate<IAnimalService, AnimalDTO> {


  /**
   * @PostMapping It's an annotation that assigns HTTP POST request to a controller method.
   * @param service it's an argument that extends from the superclass ACrudControllerTemplate.
   * @return an Item saved.
   */
  public AnimalController(IAnimalService service) {
    super(service);
  }

  @Override
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  protected ResponseEntity<ResponseDefault> save(@RequestBody AnimalDTO animalDTO) {
    return this.service.saveItem(animalDTO);
  }

  /**
   * @DeleteMapping Annotation that maps a HTTP DELETE request on the specific method.
   * @param id the ID passed by argument of the deleteById function.
   * @return the item deleted.
   */
  @Override
  @DeleteMapping(path = "/{id}")
  protected ResponseEntity<ResponseDefault> deleteById(@PathVariable int id) {
    return this.service.deleteItem(id);
  }


  /**
   * @GetMapping annotation for a HTTP GET that handle a specific method.
   * @return all items in ACrudControllerTemplate
   */
  @Override
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  protected ResponseEntity<ResponseDefault> findAll() {
    return this.service.getAllItems();
  }

  /**
   * @GetMapping annotation for a HTTP GET that handle a specific method.
   * @return one items in ACrudControllerTemplate by it's ID
   */
  @Override
  @GetMapping(path = "/animal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  protected ResponseEntity<ResponseDefault> findById(@PathVariable int id) {
    return this.service.getItem(id);
  }

  /**
   * @PutMapping Annotation that handle a HTTP PUT request to an specific method.
   * @param animalDTO instance of the object
   * @param id the id of the interface PathVariable with a name and a value
   * @return the item updated
   * @throws ApplicationException
   */
  @Override
  @PutMapping(path = "/animal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  protected ResponseEntity<ResponseDefault> update(@RequestBody AnimalDTO animalDTO,
      @PathVariable int id) throws ApplicationException {
    return this.service.updateItem(animalDTO, id);
  }


}
