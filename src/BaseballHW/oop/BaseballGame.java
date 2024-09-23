package BaseballHW.oop;

import java.util.Scanner;

public class BaseballGame implements Game {
    private NumberGenerator numberGenerator;
    private int strike = 0;
    private int ball = 0;

    public BaseballGame() {
        this.numberGenerator = new NumberGenerator();
    }

    @Override
    public int play() {
        Scanner sc = new Scanner(System.in);
        int[] numArr = numberGenerator.getNumArr();
        int[] inputArr = new int[3];
        int attempts = 0; //현재 게임의 시도 횟수

        System.out.println("새로운 게임이 시작되었습니다! 정답을 맞춰보세요.");

        while (true) {
            getInput(sc, inputArr);
            attempts++;
            evaluateGuess(inputArr, numArr);

            if (strike == 3) {
                System.out.println("3 strike 축하합니다. 정답을 맞췄습니다.");
                break;
            }
            resetScores();
        }
        return attempts; //시도 횟수 반환
    }

    private void getInput(Scanner sc, int[] inputArr) {

        System.out.println("정답 숫자를 입력하세요 (숫자는 Enter로 구분해주세요): ");
        for (int i = 0; i < inputArr.length; i++) {
            while (true) {
                int input = sc.nextInt();
                if (input == 0) {
                    System.out.println("0을 입력할 수 없습니다. 다시 입력하세요.");
                } else if (input < 1 || input > 9) {
                    System.out.println("1부터 9까지의 숫자를 입력하세요.");
                } else if (contains(inputArr, input, i)) {
                    System.out.println("중복된 값을 입력했습니다. 다시 입력하세요");
                } else {
                    inputArr[i] = input;
                    break;
                }
            }
        }
    }

    private boolean contains(int[] arr, int value, int limit) {
        for (int i = 0; i < limit; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    private void evaluateGuess(int[] inputArr, int[] numArr) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < inputArr.length; i++) {
            for (int j = 0; j < numArr.length; j++) {
                if (inputArr[i] == numArr[j]) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
        System.out.println(strike + " strike, " + ball + " ball 입니다.");
    }

    private void resetScores() {
        strike = 0;
        ball = 0;
    }
}

