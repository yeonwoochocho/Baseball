package BaseballHW.oop;

import java.util.Scanner;

public class BaseballApp {
    private int gameCount = 0; //게임 횟수
    private int totalAttempts = 0; //총 시도 횟수

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력하세요");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int choice = sc.nextInt();

            if (choice == 1) {
                gameCount++;
                BaseballGame game = new BaseballGame();
                System.out.println("게임이 끝났습니다. 총 시도횟수: "+totalAttempts);
            } else if (choice == 2) {
                System.out.println("게임을 시도한 횟수: " + totalAttempts);
            } else if (choice == 3) {
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력해주세요");
            }
        }
    }

//    public void showRecords() {
//        System.out.println("게임 기록 기능은 아직 구현되지 않았습니다.");
//    }

    public static void main(String[] args) {
        BaseballApp baseballApp = new BaseballApp();
        baseballApp.mainMenu();
    }
}
