package ru.itis.inform.DAO;

import ru.itis.inform.DAO.Model.Book;

import java.util.List;

public interface BookDao {
    void add(String name, String price);
    void delete(int id);
    void update(int id, String price);
    Book get(int id);
    List<Book> getAll();
}