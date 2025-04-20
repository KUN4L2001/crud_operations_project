package com.example.crud_operations_project_backend.dao;

import com.example.crud_operations_project_backend.dto.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonDao {

    List<Person> getAllPerson();

    void createPerson(@Param("person") Person person);

    Person findPersonById(@Param("id") String id);

    void updatePerson(@Param("updatedPerson") Person updatedPerson);

    void deletePersonById(@Param("id") String id);
}
