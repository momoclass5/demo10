package com.example.demo10.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo10.dto.BookDto;

@SpringBootTest
public class BookMapperTest {

    @Autowired
    BookMapper mapper;

    @Test
    void testGetTime() {
        String time = mapper.getTime();
        assertNotNull(time);
    }

    @Test
    void testSelectTime() {
        String time = mapper.selectTime();
        assertNotNull(time);
    }

    @Test
    void testSelectBookList() {
        List<BookDto> list = mapper.selectBookList();
        assertEquals(128, list.size());
    }

    @Test
    void testSelectBook() {
        BookDto book = mapper.selectBook("B00001");
        assertEquals("오늘도맑음", book.getTitle());
    }
}
