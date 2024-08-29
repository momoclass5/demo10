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
        // 필드에 파라메터 세팅
        this.selectDto = selectDto;

        // 1. 페이지 블럭의 끝번호 구하기
        // 페이지블럭당 보여줄 페이지의 수
        double pageBlockAmount = 5.0;
        // 요청한 페이지 번호와
        // 페이지 블럭당 보여줄 페이지의 수를 알면 페이지의 끝번호를 구할수 있다
        endPage = (int) (Math.ceil(selectDto.getPageNo() / pageBlockAmount) * pageBlockAmount);

        // 2. 페이지 블럭의 시작번호 구하기
        startPage = endPage - ((int) pageBlockAmount - 1);

        // 3. 총게시물의 건수를 페이지당보여줄 게시물의 수로 나누어 실제 끝페이지번호를 계산
        // * 1.0을 곱해주어 더블타입으로 변환
        int realEndPage = (int) Math.ceil(totalCnt * 1.0 / selectDto.getAmount());
        // 코드가 한줄인경우 코드블럭을 생략 할수 있다
        if (endPage > realEndPage) {
            endPage = realEndPage;
        }

        // startPage가 1이면 안보여줌
        // 조건 ? 참일때반환값 : 거짓일때반환값;
        prev = startPage == 1 ? false : true;
        // 진짜끝번호가 더 큰경우 다음버튼 보여줌
        next = realEndPage > endPage ? true : false;
    }
}
