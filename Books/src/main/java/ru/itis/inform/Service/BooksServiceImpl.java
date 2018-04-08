package ru.itis.inform.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.inform.DAO.BookDao;
import ru.itis.inform.DAO.JdbcTemplateDaoImpl;
import ru.itis.inform.DAO.JpaBasedDaoImpl;
import ru.itis.inform.DAO.Model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksServiceImpl implements BooksService {
    private Logger log = LoggerFactory.getLogger(BooksServiceImpl.class);

//    @Autowired
    BookDao service = new JpaBasedDaoImpl();

    public void setDao(BookDao bookDao){
        this.service = bookDao;
    }

    @Override
    public void add(String name, String price) {
        service.add(name, price);
        log.info("Add book with name = {} and price = {}", name, price);
    }

    @Override
    public void delete(int id) {
        service.delete(id);
        log.info("Delete book by id = {}", id);
    }

    @Override
    public void update(int id, String price) {
        service.update(id, price);
        log.info("Update book with id = {}", id);
    }

    @Override
    public Book get(int id) {
        log.info("Get book by id = {}", id);
        return service.get(id);
    }

    @Override
    public List<Book> getAll() {
        log.info("getAll");
        return service.getAll();
    }
}
