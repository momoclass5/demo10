package com.example.demo10.dto;

import lombok.Data;

@Data
public class PageDto {
    // 페이지블럭을 그리는데 필요한 정보---------------
    // 페이지블럭 시작번호
    private int startPage;
    // 페이지블럭 끝번호
    private int endPage;
    // prev 버튼 표시
    private boolean prev;
    // next 버튼 표시
    private boolean next;
    // -------------------------------------------
    // 블럭을 그리는데 필요한 정보를 추출하기 위한 데이터
    private SelectDto selectDto; // 페이지번호, 페이지당 게시물수
    private int totalCnt; // 게시물의 총건수

    public PageDto(SelectDto selectDto, int totalCnt) {

        // 1. 페이지 블럭의 끝번호 구하기
        // 페이지블럭당 보여줄 페이지의 수
        double pageBlockAmount = 10.0;
        // 요청한 페이지 번호와
        // 페이지 블럭당 보여줄 페이지의 수를 알면 페이지의 끝번호를 구할수 있다
        int endPage = (int) (Math.ceil(selectDto.getPageNo() / pageBlockAmount) * 10);

        // 2. 페이지 블럭의 시작번호 구하기
        int startPage = endPage - ((int) pageBlockAmount - 1);
    }
}
