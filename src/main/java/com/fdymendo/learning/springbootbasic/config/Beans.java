package com.fdymendo.learning.springbootbasic.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Bean it's a component that can be reused and manipulated.
 */
@Configuration
public class Beans {

  @Bean
  public ModelMapper beanModelMapper() {
    return new ModelMapper();
  }

}
