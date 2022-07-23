package pl.coderslab.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.person.service.PersonService;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "person/add";
    }

//    @PostMapping("/add")
//    @ResponseBody
//    public String save(@RequestParam String login, @RequestParam String password, @RequestParam String email) {
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        personService.savePerson(person);
//        return "Osoba zapisana";
//    }

    @PostMapping("/add")
    @ResponseBody
    public String save(Person person) {
        personService.savePerson(person);
        return "Osoba zapisana";
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
