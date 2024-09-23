package BaseballHW.oop2;

import java.util.Scanner;

public // MainMenu 클래스 (프로그램의 실행 흐름 제어)
class MainMenu {
    private GameRecord gameRecord = new GameRecord();
    private int digit = 3; //기본 자릿수는 3으로 설정

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력하세요");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("설정하고자 하는 자리수를 입력하세요. (3, 4, 5)");
                int selectedDigit = sc.nextInt();
                if (selectedDigit == 3 || selectedDigit == 4 || selectedDigit == 5) {
                    digit = selectedDigit;
                    System.out.println(digit + "자리수 난이도로 설정되었습니다.");
                } else {
                    System.out.println("잘못된 입력입니다. 3, 4, 5 중에서 선택하세요.");
                }
            } else if (choice == 1) {
                BaseballGame game = new BaseballGame();
                game.setDigit(digit); //자릿수 설정
                game.inputNumber();
                gameRecord.addRecord(game.getAttemptCount()); // 시도 횟수 기록
            } else if (choice == 2) {
                gameRecord.showRecords();
            } else if (choice == 3) {
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
    }
}
