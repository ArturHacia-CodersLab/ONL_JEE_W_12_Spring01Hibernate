package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @RequestMapping("/add")
    @ResponseBody
    public String addAuthor() {
        Author author = new Author();
        author.setFirstName("Henryk");
        author.setLastName("Sienkiewicz");
        authorService.saveAuthor(author);
        return "Id dodanego autora to:" + author.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        return author.toString();
    }

    @RequestMapping("/all")
    @ResponseBody
    public String findAll() {
        return authorService.findAll().toString();
    }

    @RequestMapping("/update/{id}/{lastName}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id, @PathVariable String lastName) {
        Author author = authorService.findById(id);
        author.setLastName(lastName);
        authorService.update(author);
        return author.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        return "deleted";
    }
}
