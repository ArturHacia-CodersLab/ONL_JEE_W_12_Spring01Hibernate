package pl.coderslab.book;

import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
       Query query = entityManager.createQuery("select b from Book b");
       return query.getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        Query query = entityManager.createQuery("select b from Book b where b.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> getBookWithPublisher() {
        Query query = entityManager.createQuery("select distinct b from Book b join b.publisher");
        return query.getResultList();
    }

    public List<Book> getBookWithPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("select distinct b from Book b where b.publisher = :publisher");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> getBookWithAuthor(Author author) {
        Query query = entityManager.createQuery("select distinct b from Book b where b.authors in :author");
        query.setParameter("author", author);
        return query.getResultList();
    }

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }
}
