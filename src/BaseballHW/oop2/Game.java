package BaseballHW.oop2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Game 추상 클래스 (난수 생성 및 입력 처리 포함)
abstract class Game {
    protected int[] numArr; // 정답 배열
    protected int[] inputArr; // 사용자 입력 배열
    protected int strike = 0;
    protected int ball = 0;
    protected int attemptCount = 0; // 시도 횟수 추적
    protected int digit; //자릿수 선언

    public void setDigit(int digit) {
        this.digit = digit;
        this.numArr = new int[digit];
        this.inputArr = new int[digit];
    }
    public abstract void random(); // 난수 생성
    public abstract void inputNumber();// 사용자 입력 및 게임 진행


}

// BaseballGame 클래스는 Game 추상 클래스를 상속하여 다형성 구현








