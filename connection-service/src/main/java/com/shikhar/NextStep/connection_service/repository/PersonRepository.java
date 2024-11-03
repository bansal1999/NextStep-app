package com.shikhar.NextStep.connection_service.repository;

import com.shikhar.NextStep.connection_service.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends Neo4jRepository<Person, Long> {
    Optional<Person> getByName(String name);

    @Query("MATCH (personA:person) -[:CONNECTED_TO]- (personB:person) " +
            "WHERE personA.userId = $userId " +
            "RETURN personB")
    List<Person> getFirstDegreeConnection(Long userId);
}
