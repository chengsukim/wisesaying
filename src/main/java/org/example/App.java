package org.example;

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


        // 스캐너 초기화
        // 명언앱 출력매체
        System.out.println("== 명언앱 == ");
        Scanner sc = new Scanner(System.in);

        // 명언 번호를 증가 시켜줄 long타입 변수 선언
        long lastWiseSayingId = 1;
        // WiseSaying 객체 배열을 공유하기 위한 List 변수 선언
        // WiseSaying 객체에 인스턴스배열을 선언해 줌으로써 객체타입을 받을 수 있다.
        List<WiseSaying>wiseSayings = new ArrayList<>();
        // while 반복문을 이용하여 조건에 부합할 때 까지 출력
        while (true) {
            System.out.printf("명령) ");
            // 문자열을 받기위한 String command 변수 선언
            String command = sc.nextLine().trim();
            // 조건에 부합했을 시 의도한 바를 출력 할 수 있게 조건문 선언
            if (command.equals("종료")) {
                System.out.println("시스템을 종료합니다");
                break;
            }

            // 명언과 작가를 등록하기 위해 else-if 조건문으로 연결시켜 출력시키기
            else if (command.equals("등록")) {
                // 명언 출력매체
                System.out.printf("명언 : ");
                // 명언을 출력해주기 위한 문자열 변수선언
                String content = sc.nextLine().trim();
                // 작가 출력매체
                System.out.printf("작가 : ");
                // 작가정보를 출력해주기 위한 문자열 변수선언
                String author = sc.nextLine().trim();
                // 위에 long 타입 변수를 이용해 명언 번호가 증가하도록 출력
                System.out.printf("%d번 명언이 등록되었습니다\n" , lastWiseSayingId);

                // new WiseSaying이라는 객체를 선언해 줌으로써 WiseSaying 클래스 안에 있는 객체 함수를 받아온다
                WiseSaying wiseSaying = new WiseSaying(lastWiseSayingId , content , author);
                // ArrayList객체에 있는 wiseSayings변수에 wiseSaying 객체 함수를 더해주기 위해 add 변수선언
                wiseSayings.add(wiseSaying);


                // 출력이 될때마다 명언번호가 증가해야 하기 때문에 증가부호를 붙여줌
                lastWiseSayingId++;

            } else if (command.equals("목록")) {
                System.out.println("번호 / 명언 / 작가\n");
           // 순환적으로 목록을 등록하기 위한 for반복문 선언
            for(int i = wiseSayings.size(); i >= 0; i--) {
               WiseSaying wiseSaying = wiseSayings.get(i);
                System.out.printf("%d / %s / %s\n" , wiseSaying.getId() , wiseSaying.getContent(),wiseSaying.getAuthor());

            }

            }

        }
    }
}
