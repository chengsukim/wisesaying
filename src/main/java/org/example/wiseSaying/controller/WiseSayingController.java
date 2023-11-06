package org.example.wiseSaying.controller;

import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    // WiseSaying 객체 배열을 공유하기 위한 List 변수 선언
    // WiseSaying 객체에 인스턴스배열을 선언해 줌으로써 객체타입을 받을 수 있다.
    private final Scanner sc;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    long lastWiseSayingId = 0;
  public WiseSayingController(Scanner sc) {
        this.sc = sc;
    }
    public void write(){
        // 명언 번호를 증가 시켜줄 long타입 변수 선언
        long id = lastWiseSayingId+1;
        // 명언 출력매체
        System.out.printf("명언 : ");
        // 명언을 출력해주기 위한 문자열 변수선언
        String content = sc.nextLine().trim();
        // 작가 출력매체
        System.out.printf("작가 : ");
        // 작가정보를 출력해주기 위한 문자열 변수선언
        String author = sc.nextLine().trim();
        // 위에 long 타입 변수를 이용해 명언 번호가 증가하도록 출력
        System.out.printf("%d번 명언이 등록되었습니다\n", id);

        // new WiseSaying이라는 객체를 선언해 줌으로써 WiseSaying 클래스 안에 있는 객체 함수를 받아온다
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        // ArrayList객체에 있는 wiseSayings변수에 wiseSaying 객체 함수를 더해주기 위해 add 변수선언
        wiseSayings.add(wiseSaying);
        lastWiseSayingId = id;


        // 출력이 될때마다 명언번호가 증가해야 하기 때문에 증가부호를 붙여줌

    }

    public void list() {
        System.out.println("번호 / 명언 / 작가\n");
        // 순환적으로 목록을 등록하기 위한 for반복문 선언
        for (int i = 0; i < wiseSayings.size(); i++) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor());

        }
    }
}
