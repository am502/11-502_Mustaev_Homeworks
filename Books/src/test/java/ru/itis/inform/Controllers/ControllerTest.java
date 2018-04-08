package ru.itis.inform.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.itis.inform.DAO.Model.Book;
import ru.itis.inform.Service.BooksService;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.itis.inform.DAO.BookDaoData.BOOK_1;
import static ru.itis.inform.DAO.BookDaoData.BOOK_2;

public class ControllerTest {
//    Book BOOK_1 = new Book(12, "Some book 1", "1000");
//    Book BOOK_2 = new Book(13, "Some book 2", "2000");
    private MockMvc mockMvc;

    @Mock
    BooksService booksService;

    @InjectMocks
    private Controller controller;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(booksService.get(BOOK_1.getId())).thenReturn(BOOK_1);
        when(booksService.getAll()).thenReturn(Lists.newArrayList(BOOK_1, BOOK_2));
    }

    @Test
    public void testGetById() throws Exception {
        mockMvc.perform(get("/book/{user-id}", BOOK_1.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(BOOK_1.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(BOOK_1.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", is(BOOK_1.getPrice())));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/show").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", Is.is(BOOK_1.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", is(BOOK_1.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].price", is(BOOK_1.getPrice())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id", is(BOOK_2.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].name", is(BOOK_2.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].price", is(BOOK_2.getPrice())));
    }
}