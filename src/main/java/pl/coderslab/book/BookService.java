package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;
import pl.coderslab.publisher.Publisher;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;
    private final BookRepository bookRepository;

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public Book findWithAutorsById(long id) {
        return getAuthorsForBook(bookDao.findById(id));
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public List<Book> findAllByRating(int rating) {
        return bookDao.findAllByRating(rating);
    }

    public List<Book> getBookWithPublisher() {
        return bookDao.getBookWithPublisher();
    }

    public List<Book> getBookWithPublisher(Publisher publisher) {
        return bookDao.getBookWithPublisher(publisher);
    }

    public List<Book> getBookWithAuthor(Author author) {
        return bookDao.getBookWithAuthor(author);
    }

    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(Book book) {
        bookDao.delete(book);
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }

    public List<Book> findBooksByCategory(Category category) {
        return bookRepository.findBooksByCategory(category);
    }

    public List<Book> findBooksByCategoryId(long id) {
        return bookRepository.findBooksByCategoryId(id);
    }

    private Book getAuthorsForBook(Book book) {
        if (book != null) {
            Hibernate.initialize(book.getAuthors());
        }
        return book;
    }
}
