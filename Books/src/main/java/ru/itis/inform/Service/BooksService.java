package ru.itis.inform.Service;

import ru.itis.inform.DAO.BookDao;
import ru.itis.inform.DAO.Model.Book;

import java.util.List;

public interface BooksService {
    void setDao(BookDao bookDao);
    void add(String name, String price);
    void delete(int id);
    void update(int id, String price);
    Book get(int id);
    List<Book> getAll();
}
