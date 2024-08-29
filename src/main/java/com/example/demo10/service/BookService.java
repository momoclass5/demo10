package com.example.demo10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo10.dto.BookDto;
import com.example.demo10.dto.SelectDto;
import com.example.demo10.mapper.BookMapper;

@Service
public class BookService {
    @Autowired
    BookMapper mapper;

    public List<BookDto> selectBookList() {
        return mapper.selectBookList();
    }

    public BookDto selectBook(String b_no) {
        return mapper.selectBook(b_no);
    }

    public int deleteBook(String b_no) {
        return mapper.deleteBook(b_no);
    }

    public Object selectBookListPageing(SelectDto selectDto) {
        return mapper.selectBookListPageing(selectDto);
    }
}
