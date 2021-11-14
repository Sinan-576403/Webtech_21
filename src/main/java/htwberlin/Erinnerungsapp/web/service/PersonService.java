package htwberlin.Erinnerungsapp.web.service;

import htwberlin.Erinnerungsapp.web.api.Person;
import htwberlin.Erinnerungsapp.web.api.PersonCreateRequest;
import htwberlin.Erinnerungsapp.web.persistence.PersonEntity;
import htwberlin.Erinnerungsapp.web.persistence.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Person findById(Long id){
        var personEntity = personRepository.findById(id);
        return personEntity.map(this::transformEntity).orElse(null);
    }

    public Person create(PersonCreateRequest request) {
        var personEntity = new PersonEntity(request.getFirstName(), request.getLastName(), request.isVaccinated());
        personEntity = personRepository.save(personEntity);
        return transformEntity(personEntity);
    }

    private Person transformEntity(PersonEntity personEntity) {
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                personEntity.isVaccinated()
        );



    }
}