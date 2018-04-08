package ru.itis.inform.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.itis.inform.DAO.BookDao;
import ru.itis.inform.DAO.JdbcTemplateDaoImpl;
import ru.itis.inform.DAO.Model.Book;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BooksServiceImplTest {
    BooksService service;
    List<Book> list;
    Book checkBook = new Book(12, "Some book", "1000");
    @Mock
    BookDao bookdao;
    @Before
    public void setUp() throws Exception{
        service = new BooksServiceImpl();
        service.setDao(bookdao);
        doNothing().when(bookdao).delete(5);
        doNothing().when(bookdao).update(5, "900");
        doNothing().when(bookdao).add("Some book", "1000");
        doReturn(null).when(bookdao).get(10);
        doReturn(null).when(bookdao).getAll();
        doReturn(checkBook).when(bookdao).get(5);
    }

    @org.junit.Test
    public void add() throws Exception {
        service.add("Some book", "1000");
        verify(bookdao).add("Some book", "1000");
    }

    @org.junit.Test
    public void delete() throws Exception {
        service.delete(5);
        verify(bookdao).delete(5);
    }

    @org.junit.Test
    public void update() throws Exception {
        service.update(5, "900");
        verify(bookdao).update(5, "900");
    }

    @org.junit.Test
    public void get() throws Exception {
        assertEquals(null, service.get(10));
        assertEquals(checkBook, service.get(5));
    }

    @org.junit.Test
    public void getAll() throws Exception {
        assertEquals(list, service.getAll());
    }

}