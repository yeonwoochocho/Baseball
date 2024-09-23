package BaseballHW;

import java.util.Scanner;


public class baseballApp {

    int numArr[] = new int[3]; //크기 3인 정답 배열 생성
    int inputArr[] = new int[3]; //사용자가 입력할 숫자 배열
    int strike = 0;
    int ball = 0;

    //난수 생성
    public void random() {
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int) (Math.random() * 9 + 1); //난수 생성
            for (int j = 0; j < i; j++) {
                if (numArr[j] == numArr[i]) {
                    i--; //중복값 있으면 반복문 빠져나감
                    break;
                }

            }
        }
        for (int x : numArr) { //랜덤 숫자 확인
            System.out.print(x + " ");
        }
        System.out.println();
    }


    public void inputNumber() { //사용자 입력 메서드
        Scanner sc = new Scanner(System.in);

        random();
        while (true) {
            System.out.println("정답 숫자를 입력하세요 (숫자는 Enter로 구분해주세요): ");
            for (int i = 0; i < inputArr.length; i++) {
                int input = sc.nextInt();
                if (input == 0) { // 0 입력 불가
                    System.out.println("0을 입력할 수 없습니다. 다시 입력하세요.");
                    i--; // 인덱스 감소
                    continue; // 다음 반복으로 넘어감
                } else if (input < 1 || input > 9) { // 1~9 범위 체크
                    System.out.println("1부터 9까지의 숫자를 입력하세요.");
                    i--; // 인덱스 감소
                    continue; // 다음 반복으로 넘어감
                }

                for (int j = 0; j < i; j++) {
                    if (inputArr[j] == input) { // 중복 숫자 입력 불가
                        System.out.println("중복된 값을 입력했습니다. 다시 입력하세요");
                        i--; // 인덱스 감소
                        break; // 중복일 경우 루프 탈출
                    }
                }
                inputArr[i] = input; // 유효한 입력 저장
            }

            // 입력한 정답 숫자를 비교하여 strike인지 ball인지 판단
            for (int i = 0; i < inputArr.length; i++) {
                for (int j = 0; j < numArr.length; j++) {
                    if (inputArr[i] == numArr[j] && i == j) {
                        // 같은 숫자, 같은 인덱스이면 스트라이크
                        strike++;
                    } else if (inputArr[i] == numArr[j] && i != j) {
                        // 같은 숫자, 다른 인덱스이면 볼
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
            System.out.println("게임을 더 진행하시겠습니까?");
        }
    }

    public void showRecords() {
        System.out.println("게임 기록 기능은 아직 구현되지 않았습니다.");
    }

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("환영합니다! 원하시는 번홀를 입력하세요");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int choice = sc.nextInt();

            if (choice == 1) {
                inputNumber();
            } else if (choice == 2) {
                showRecords();
            } else if (choice == 3) {
                System.out.println("게임을 종료합니다. ");
                break;
            } else {
                System.out.println("잘못된 선택입니다. 다시 입력해주세요");
            }
        }
    }

    public static void main(String[] args) {
        baseballApp baseball = new baseballApp();
        baseball.mainMenu();
//
    }
}

