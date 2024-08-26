package com.example.demo10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo10.dto.BookDto;
import com.example.demo10.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BookController {
    @Autowired
    BookService service;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("list", service.selectBookList());
        return "book/list";
    }

    // 매핑url과 반환하려는 값이 같은경우 반환 생략가능
    @GetMapping("/book/write")
    public void write() {
    }

    @GetMapping("/book/detail")
    public String getMethodName(BookDto book, Model model) {
        // 서버에 데이터가 전달 되는지 확인
        log.info(book.getB_no());
        // 경우에 따라 페이지를 다르게 보여줄 수 있다
        if (book.getB_no() != null) {
            book = service.selectBook(book.getB_no());
            model.addAttribute("book", book);
            return "/book/detail";
        } else {
            // 메세지 출력후 이전 화면으로
            model.addAttribute("msg", "도서번호(필수)가 입력되지 않았습니다.");
            // 이동할 페이지가 있다면 페이지 주소를 저장
            // model.addAttribute("url", "/book/detail");
            return "common/msg";
        }
    }

    @GetMapping("/book/delete")
    public String getMethodName(@RequestParam(required = false, name = "b_no") String b_no, Model model) {
        if (b_no == null) {
            model.addAttribute("msg", "도서번호가 입력되지 않았습니다.");
            return "/common/msg";
        }
        // 삭제후 결과를 반환
        int res = service.deleteBook(b_no);
        if (res > 0) {
            // 1. 정상적으로 삭제 처리 -> 리스트
            model.addAttribute("msg", "삭제 되었습니다.");
            model.addAttribute("url", "/");
        } else {
            // 2. 삭제처리가 안되었을때 -> 메세지 출력후 뒤로가기
            model.addAttribute("msg", "삭제 중 예외가 발생 하였습니다.\n관리자에게 문의해주세요");
        }

        // model 객체에 저장된 msg를 출력하고 화면을 전환
        // 뒤로가기 또는 url 로 이동
        return "common/msg";
    }

}
