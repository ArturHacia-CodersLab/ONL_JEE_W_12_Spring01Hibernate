package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.category.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByTitle(String title);

    List<Book> findBooksByCategory(Category category);

    List<Book> findBooksByCategoryId(long id);
}
