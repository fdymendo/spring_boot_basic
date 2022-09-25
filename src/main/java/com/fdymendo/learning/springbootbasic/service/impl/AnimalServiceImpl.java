package com.fdymendo.learning.springbootbasic.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.fdymendo.learning.springbootbasic.dto.AnimalDTO;
import com.fdymendo.learning.springbootbasic.entities.AnimalEntity;
import com.fdymendo.learning.springbootbasic.handlers.ApplicationException;
import com.fdymendo.learning.springbootbasic.model.ResponseDefault;
import com.fdymendo.learning.springbootbasic.repository.AnimalRepository;
import com.fdymendo.learning.springbootbasic.service.ACrudServiceTemplate;
import com.fdymendo.learning.springbootbasic.service.IAnimalService;
import com.fdymendo.learning.springbootbasic.utils.ApplicationConstant;
import com.fdymendo.learning.springbootbasic.utils.GenericMethods;

@Service
public class AnimalServiceImpl extends ACrudServiceTemplate<AnimalRepository, AnimalEntity>
    implements IAnimalService {

  private ModelMapper modelMapper;

  public AnimalServiceImpl(AnimalRepository repository, ModelMapper modelMapper) {
    super(repository);
    this.modelMapper = modelMapper;
  }

  @Override
  public ResponseEntity<ResponseDefault> saveItem(AnimalDTO item) {

    item.cleanRequest();

    AnimalEntity animalEntity = this.modelMapper.map(item, AnimalEntity.class);
    animalEntity.init();

    this.repository.save(animalEntity);
    item = this.modelMapper.map(animalEntity, AnimalDTO.class);

    ResponseDefault responseDefault = new ResponseDefault();
    responseDefault.setItem(item);

    return GenericMethods.responseOk(responseDefault);
  }

  @Override
  public ResponseEntity<ResponseDefault> deleteItem(int id) {

    this.repository.deleteById(id);

    return GenericMethods.responseNoContent();
  }

  @Override
  public ResponseEntity<ResponseDefault> getItem(int id) {

    AnimalEntity animalEntity = this.repository.getReferenceById(id);
    AnimalDTO animalDTO = this.modelMapper.map(animalEntity, AnimalDTO.class);

    ResponseDefault responseDefault = new ResponseDefault();
    responseDefault.setItem(animalDTO);

    return GenericMethods.responseOk(responseDefault);
  }

  @Override
  public ResponseEntity<ResponseDefault> getAllItems() {
    ResponseDefault responseDefault = new ResponseDefault();
    List<AnimalEntity> animalEntities = this.repository.findAll();
    responseDefault.setItems(animalEntities.stream()
        .map(n -> this.modelMapper.map(n, AnimalDTO.class)).collect(Collectors.toList()));
    return ResponseEntity.ok(responseDefault);
  }

  @Override
  public ResponseEntity<ResponseDefault> updateItem(AnimalDTO item, int id)
      throws ApplicationException {

    item.cleanRequest();
    item.setId(id);

    AnimalEntity animalEntity = this.modelMapper.map(item, AnimalEntity.class);
    animalEntity.init();

    // Optional in DB H2
    AnimalEntity tmp = null;
    try {
      tmp = this.findById(id);
    } catch (Exception e) {
      throw new ApplicationException(e, ApplicationConstant.ERROR_MESSAGE_500,
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
    animalEntity.setCreationDate(tmp.getCreationDate());

    this.repository.save(animalEntity);
    item = this.modelMapper.map(animalEntity, AnimalDTO.class);

    ResponseDefault responseDefault = new ResponseDefault();
    responseDefault.setItem(item);

    return GenericMethods.responseOk(responseDefault);
  }

}
