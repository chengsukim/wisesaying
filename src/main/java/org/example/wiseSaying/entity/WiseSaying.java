package org.example.wiseSaying.entity;

public class WiseSaying {
    // 번호에들어갈 인스턴스 정수형 변수
    private long id;
    // 명언에 들어갈 인스턴스 문자열 변수
    private String content;
    // 작가에 들어갈 인스턴스 문자열 변수
    private String author;

    // WiseSaying 클래스에서 선뇬언된 변수들을 다른 클래스와 공유하기 위해 생성자 함수 선언
    public WiseSaying (long id , String content , String author){
        this.id = id;
        this.content = content;
        this.author = author;
    }
    // WiseSaying 부모함수에 private 라는 직접접근 변수가 선언되있어
    // 자식함수에 해당되는 WiseSaying 생성자 함수를 공유받을 수 없으므로
    // 새로운 생성자 함수를 선언하여 목록을 출력

    public long getId () {
        return this.id;
    }

    public String getContent(){
        return this.content;
    }

    public String getAuthor(){
        return this.author;
    }
}
