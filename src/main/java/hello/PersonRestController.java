package hello;

import model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.CrudRepository.PersonRepository;

import java.util.List;

/**
 * Created by Zlink on 10/3/2560.
 */
@RestController
@RequestMapping("/person")
public class PersonRestController {

    PersonRepository repository = new PersonRepository();
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> AddPerson(@RequestBody Person person) {
        repository.save(person);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> GetAllPerson() {
        return new ResponseEntity<List<Person>>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public ResponseEntity<Void> DeletePerson(@PathVariable("id") int id) {
        repository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Person> FindPerson(@PathVariable("id") int id) {
        return new ResponseEntity<Person>(repository.findone(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public ResponseEntity<Void> UpdatePerson(@RequestBody Person person,@PathVariable("id") int id) {
        repository.update(person,id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }




}
