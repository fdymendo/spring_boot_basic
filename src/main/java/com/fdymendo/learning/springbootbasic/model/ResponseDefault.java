package com.fdymendo.learning.springbootbasic.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fdymendo.learning.springbootbasic.dto.AnimalDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ResponseDefault {

  private List<AnimalDTO> items;
  private AnimalDTO item;

}
