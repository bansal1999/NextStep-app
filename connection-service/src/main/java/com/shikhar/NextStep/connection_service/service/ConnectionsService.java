package com.shikhar.NextStep.connection_service.service;

import com.shikhar.NextStep.connection_service.entity.Person;
import com.shikhar.NextStep.connection_service.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ConnectionsService {
    private final PersonRepository personRepository;

    public List<Person> getFirstDegreeConnections(Long userId){
        log.info("getFirstDegreeConnections for user with id: {}", userId);

        return personRepository.getFirstDegreeConnection(userId);
    }
}
