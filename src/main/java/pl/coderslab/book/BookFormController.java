package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.publisher.Publisher;
import pl.coderslab.publisher.PublisherService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book/form")
@RequiredArgsConstructor
public class BookFormController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String save(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/add";
        }
        bookService.saveBook(book);
        return "redirect:/book/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("book", bookService.findWithAutorsById(id));
        return "/book/add";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable long id, @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/book/add";
        }
        bookService.update(book);
        return "redirect:/book/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "/book/confirm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        bookService.delete(bookService.findById(id));
        return "redirect:/book/form/all";
    }
}
