package org.example;

// 코드 최적화를 위해 시스템 모듈과 명언 모듈을 생성
// 리펙토링을 통한 코드최적화를 이용해 코드구분을 쉽게 할 수 있다.

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class App {
    // 최적화를 위한 로직 main은 출력만을 담당

    // 직접접근 변수로 private를 주로 쓰고 final을 선언하면 더 이상 수정을 하지 않겠다는 변수
    // Scanner를 최초에 한번만 세팅하기 위헤 선언
    private final Scanner sc;

    // 어플리케이션 로직을 모아둔 생성자 함수
    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        // 시스템 모듈과 명언 모듈을 공유하기 위해 애플리케이션에 객체를 생성
        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        // 스캐너 초기화
        // 명언앱 출력매체
        System.out.println("== 명언앱 == ");
        Scanner sc = new Scanner(System.in);

        // while 반복문을 이용하여 조건에 부합할 때 까지 출력
        while (true) {
            System.out.printf("명령) ");
            // 문자열을 받기위한 String command 변수 선언
            String command = sc.nextLine().trim();
            // 조건에 부합했을 시 의도한 바를 출력 할 수 있게 조건문 선언
            if (command.equals("종료")) {
                systemController.exit();
                break;
            }

            // 명언과 작가를 등록하기 위해 else-if 조건문으로 연결시켜 출력시키기
            else if (command.equals("등록")) {
                // 명언 모듈에 있는 등록 코드들을 가져오기위해 wiseSayingController변수에
                // WiseSayingController클래스안에 있는 write생성자 함수를 연결
                wiseSayingController.write();

            } else if (command.equals("목록")) {
                // 명언 모듈에 있는 목록 코드들을 가져오기위해 wiseSayingController변수에
                // WiseSayingController클래스안에 있는 list생성자 함수를 연결
                wiseSayingController.list();
            } else if (command.equals("삭제")) {
                System.out.println("");

            }

        }
    }
}
