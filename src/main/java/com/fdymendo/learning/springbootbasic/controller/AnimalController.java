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
 * @RestController It's a petition with a specific declared JSON format
 * @RequestMapping Annotation that relate a method with a http petition.
 */
@RestController
@RequestMapping(path = "/animals/v1")
public class AnimalController extends ACrudControllerTemplate<IAnimalService, AnimalDTO> {

    public AnimalController(IAnimalService service) {
        super(service);
    }

    /**
     * Method to save an animal.
     *
     * @param animalDTO An object representing the animal to be saved and extending from the superclass ACrudControllerTemplate.
     * @return The saved object as a response.
     */
    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    protected ResponseEntity<ResponseDefault> save(@RequestBody AnimalDTO animalDTO) {
        return this.service.saveItem(animalDTO);
    }

    /**
     * Method to delete an animal by its ID.
     *
     * @param id The ID of the animal to be deleted, passed as an argument to the deleteItem function.
     * @return The deleted object as a response.
     */
    @Override
    @DeleteMapping(path = "/{id}")
    protected ResponseEntity<ResponseDefault> deleteById(@PathVariable int id) {
        return this.service.deleteItem(id);
    }

    /**
     * Method to get all animals.
     *
     * @return All animals as a response in ACrudControllerTemplate.
     */
    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    protected ResponseEntity<ResponseDefault> findAll() {
        return this.service.getAllItems();
    }

    /**
     * Method to get an animal by its ID.
     *
     * @param id The ID of the animal to retrieve.
     * @return The animal with the specified ID as a response in ACrudControllerTemplate.
     */
    @Override
    @GetMapping(path = "/animal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    protected ResponseEntity<ResponseDefault> findById(@PathVariable int id) {
        return this.service.getItem(id);
    }

    /**
     * Method to update an animal by its ID.
     *
     * @param animalDTO An instance of the animal object to be updated.
     * @param id        The ID of the animal to be updated obtained from the PathVariable variable with the name "id".
     * @return The updated animal as a response.
     * @throws ApplicationException If an error occurs during the update.
     */
    @Override
    @PutMapping(path = "/animal/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    protected ResponseEntity<ResponseDefault> update(@RequestBody AnimalDTO animalDTO, @PathVariable int id) throws ApplicationException {
        return this.service.updateItem(animalDTO, id);
    }

}