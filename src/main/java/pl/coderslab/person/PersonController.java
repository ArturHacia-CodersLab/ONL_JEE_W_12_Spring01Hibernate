package pl.coderslab.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.person.entity.PersonDetails;
import pl.coderslab.person.service.PersonService;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/add")
    public String form(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "person/form";
    }

    @PostMapping("/add")
    @ResponseBody
    public String hello(Person person) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("Artur");
        personDetails.setLastName("Hacia");
        personDetails.setStreetNumber("54");
        personDetails.setStreet("Prosta");
        personDetails.setCity("Warszawa");

        person.setPersonDetails(personDetails);
        personService.savePerson(person);
        return "Id dodanej osoby to: " + person.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getPerson(@PathVariable long id) {
        Person person = personService.findById(id);
        return person.toString();
    }

    @RequestMapping("/update/{id}/{login}")
    @ResponseBody
    public String updatePerson(@PathVariable long id, @PathVariable String login ) {
        Person person = personService.findById(id);
        person.setLogin(login);
        personService.update(person);
        return person.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deletePerson(@PathVariable long id) {
        personService.delete(id);
        return "deleted";
    }
}
