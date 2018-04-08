package ru.itis.inform.DAO;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.inform.Configs.WebAppContext;
import ru.itis.inform.DAO.Model.Book;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Component
@Transactional
public class JpaBasedDaoImpl implements BookDao{
    public EntityManager em = Persistence.createEntityManagerFactory("JPA").createEntityManager();

    public void add(String name, String price){
        em.getTransaction().begin();
        em.merge(new Book(name, price));
        em.getTransaction().commit();
    }

    public void delete(int id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Book get(int id){
        return em.find(Book.class, id);
    }

    public void update(int id, String newPrice){
        em.getTransaction().begin();
        Book book =  em.find(Book.class, id);
        book.setPrice(newPrice);
        em.getTransaction().commit();
    }

    public List<Book> getAll(){
        TypedQuery<Book> namedQuery = em.createQuery("SELECT c FROM Book c", Book.class);
        return namedQuery.getResultList();
    }
}