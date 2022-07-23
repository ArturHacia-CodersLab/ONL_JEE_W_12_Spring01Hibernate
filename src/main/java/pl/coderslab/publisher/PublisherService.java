package pl.coderslab.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherDao publisherDao;

    public Publisher findById(long id) {
        return publisherDao.findById(id);
    }

    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }

    public void savePublisher(Publisher publisher) {
        publisherDao.savePublisher(publisher);
    }

    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    public void delete(Publisher publisher) {
        publisherDao.delete(publisher);
    }
}
