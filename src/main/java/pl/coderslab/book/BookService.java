package pl.coderslab.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;

    public Book findById(long id) {
        return bookDao.findById(id);
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
}
