package ru.itis.inform.Controllers;

import ru.itis.inform.DAO.Model.Book;
import ru.itis.inform.Service.BooksService;
import ru.itis.inform.Service.BooksServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    BooksService bookService = new BooksServiceImpl();

    @RequestMapping(value = "/")
    String showHomePage() {
        return "home";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBook(String name, String price) {
        bookService.add(name, price);
        return "success";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createForm() {
        return new ModelAndView("creating");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteBook(int id) throws SQLException {
        bookService.delete(id);
        return "success";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteForm() {
        return new ModelAndView("deleting");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String deleteBook(int id, String price) throws SQLException {
        bookService.update(id, price);
        return "success";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateForm() {
        return new ModelAndView("updating");
    }

    @RequestMapping(value = "/book/{id}")
    @ResponseBody
    public Book getBook(@PathVariable(value = "id") int id) {
        return bookService.get(id);
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public List<Book> showBooks() {
        return bookService.getAll();
    }
}