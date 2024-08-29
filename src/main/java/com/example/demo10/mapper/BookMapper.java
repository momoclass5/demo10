package com.example.demo10.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo10.dto.BookDto;
import com.example.demo10.dto.SelectDto;

@Mapper
public interface BookMapper {
    // xml 연동 없이 쿼리를 직접 작성후 테스트
    @Select("select sysdate from dual")
    public String getTime();

    public String selectTime();

    public List<BookDto> selectBookList();

    public BookDto selectBook(String b_no);

    @Delete("delete from tb_book where b_no = #{b_no}")
    public int deleteBook(String b_no);

    public List<BookDto> selectBookListPageing(SelectDto selectDto);
}
