package BaseballHW.oop2;

import java.util.Scanner;

//게임 구현
public class BaseballGame extends Game {

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
        System.out.println(digit +"자리 정답 숫자가 생성되었습니다.");
    }

    @Override
    public void inputNumber() {
        Scanner sc = new Scanner(System.in);
        random(); // 난수 생성

        while (true) {
            attemptCount++; // 시도 횟수 증가
            System.out.println(digit + "자리 정답 숫자를 입력하세요 (숫자는 Enter로 구분해주세요): ");
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
            if (strike == digit) {
                System.out.println(digit + "strike 축하합니다. 정답을 맞췄습니다.");
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
