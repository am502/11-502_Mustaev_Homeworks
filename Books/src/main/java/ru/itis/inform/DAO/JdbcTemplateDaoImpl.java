package ru.itis.inform.DAO;

import ru.itis.inform.Configs.PropertiesProvider;
import ru.itis.inform.Configs.WebAppContext;
import ru.itis.inform.DAO.Model.Book;
import ru.itis.inform.DAO.Model.BookMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;

@Component
public class JdbcTemplateDaoImpl implements BookDao {
    private WebAppContext webAppContext = new WebAppContext();
    private JdbcTemplate jdbc = new JdbcTemplate(webAppContext.dataSource());

    @Override
    public void add(String name, String price) {
        String sql = "INSERT INTO newbooks (name, price) VALUES (?, ?)";
        jdbc.update(sql, name, price);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM newbooks WHERE id = ?";
        jdbc.update(sql, id);
    }

    @Override
    public void update(int id, String price) {
        String sql = "UPDATE newbooks SET price = ? WHERE  id = ?";
        jdbc.update(sql, price, id);
    }

    @Override
    public Book get(int id) {
        String sql = "SELECT * FROM newbooks WHERE id = ?";
        Book book = (Book)jdbc.queryForObject(sql, new Object[] { id }, new BookMapper());
        return book;
    }

    @Override
    public List<Book> getAll() {
        String sql = "SELECT * FROM newbooks";
        List<Book> books = jdbc.query(sql, new BookMapper());
        return books;
    }
}
