package BaseballHW.oop2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Game 추상 클래스 (난수 생성 및 입력 처리 포함)
abstract class Game {
    protected int[] numArr = new int[3]; // 정답 배열
    protected int[] inputArr = new int[3]; // 사용자 입력 배열
    protected int strike = 0;
    protected int ball = 0;
    protected int attemptCount = 0; // 시도 횟수 추적

    public abstract void random(); // 난수 생성
    public abstract void inputNumber(); // 사용자 입력 및 게임 진행
}

// BaseballGame 클래스는 Game 추상 클래스를 상속하여 다형성 구현
class BaseballGame extends Game {

    @Override
    public void random() {
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int) (Math.random() * 9 + 1); // 난수 생성
            for (int j = 0; j < i; j++) {
                if (numArr[j] == numArr[i]) {
                    i--; // 중복값 있으면 반복문 빠져나감
                    break;
                }
            }
        }
        System.out.println("정답 숫자가 생성되었습니다.");
    }

    @Override
    public void inputNumber() {
        Scanner sc = new Scanner(System.in);
        random(); // 난수 생성

        while (true) {
            attemptCount++; // 시도 횟수 증가
            System.out.println("정답 숫자를 입력하세요 (숫자는 Enter로 구분해주세요): ");
            for (int i = 0; i < inputArr.length; i++) {
                int input = sc.nextInt();
                if (input == 0) { // 0 입력 불가
                    System.out.println("0을 입력할 수 없습니다. 다시 입력하세요.");
                    i--; // 인덱스 감소
                    continue;
                } else if (input < 1 || input > 9) { // 1~9 범위 체크
                    System.out.println("1부터 9까지의 숫자를 입력하세요.");
                    i--; // 인덱스 감소
                    continue;
                }

                for (int j = 0; j < i; j++) {
                    if (inputArr[j] == input) { // 중복 숫자 입력 불가
                        System.out.println("중복된 값을 입력했습니다. 다시 입력하세요");
                        i--; // 인덱스 감소
                        break;
                    }
                }
                inputArr[i] = input; // 유효한 입력 저장
            }

            // 입력한 정답 숫자를 비교하여 strike인지 ball인지 판단
            for (int i = 0; i < inputArr.length; i++) {
                for (int j = 0; j < numArr.length; j++) {
                    if (inputArr[i] == numArr[j] && i == j) {
                        strike++;
                    } else if (inputArr[i] == numArr[j] && i != j) {
                        ball++;
                    }
                }
            }

            System.out.println(strike + " strike, " + ball + " ball 입니다.");
            if (strike == 3) {
                System.out.println("3 strike 축하합니다. 정답을 맞췄습니다.");
                break;
            }
            strike = 0;
            ball = 0;
        }
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}

// GameRecord 클래스 (게임 기록 관리)
class GameRecord {
    private List<Integer> records = new ArrayList<>();

    public void addRecord(int attempts) {
        records.add(attempts);
    }

    public void showRecords() {
        if (records.isEmpty()) {
            System.out.println("아직 게임 기록이 없습니다.");
        } else {
            System.out.println("게임 기록:");
            for (int i = 0; i < records.size(); i++) {
                System.out.println("게임 " + (i + 1) + ": " + records.get(i) + "회 시도");
            }
        }
    }
}

// MainMenu 클래스 (프로그램의 실행 흐름 제어)
class MainMenu {
    private GameRecord gameRecord = new GameRecord();

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력하세요");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int choice = sc.nextInt();

            if (choice == 1) {
                BaseballGame game = new BaseballGame();
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


