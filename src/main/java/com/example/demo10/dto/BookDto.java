package com.example.demo10.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BookDto {
    private String b_no;
    private String title;
    private String author;
    private String price;
    private String p_no;
    private String rentyn;
    private String delyn;
    private String regdate;
    private String r_no;
}
