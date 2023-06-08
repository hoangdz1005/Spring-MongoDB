package com.springboot.SpringMongoDB.repository;

import com.springboot.SpringMongoDB.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findByFirstname(String firtsname);
    List<Person> findByLastname(String lastname);

    @Query("{'address': ?0}")
    List<Person> findPersonByAddress(String address);
    @Query("{'age': {$gt: ?0, $lt: ?1}}")
    List<Person> findByAgeRange(int minAge, int maxAge);

}
