package ru.itis.inform;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import ru.itis.inform.Service.BooksServiceImpl;

@Configuration
@ComponentScan(basePackages ={ "ru.itis.inform" }, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
public class Context {

    @Bean
    public BooksServiceImpl service(){
        return Mockito.mock(BooksServiceImpl.class);
    }
}