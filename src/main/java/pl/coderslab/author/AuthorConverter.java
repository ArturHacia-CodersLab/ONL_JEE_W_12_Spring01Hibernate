package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorService authorService;

    @Override
    public Author convert(String s) {
        return authorService.findById(Long.parseLong(s));
    }
}
