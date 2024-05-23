package com.ivoronline.springboot_database_namedparameterjdbctemplate_concatenate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  //=========================================================================================================
  // CONCATENATE
  //=========================================================================================================
  public int concatenate(String name1, Integer age1, String nameNew, String nameOld) {

    //CREATE STATEMENTS
    String statements = " INSERT INTO PERSON (NAME, AGE) VALUES ( '"+name1+"',"+age1+")         ; "+
                        " UPDATE      PERSON SET NAME = '"+nameNew+"' WHERE name = '"+nameOld+"'; ";

    return namedParameterJdbcTemplate.update(statements, new HashMap<>()); //Empty Parameters

  }

}
