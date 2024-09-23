package BaseballHW.oop;

import java.util.HashSet;
import java.util.Set;

//난수 생성 클래스

public class NumberGenerator {
    private int[] numArr = new int[3];

    public NumberGenerator() {
        generateUniqueNumbers();
    }

    private void generateUniqueNumbers() {
        Set<Integer> generatedNumbers = new HashSet<>();
        while (generatedNumbers.size() < 3) {
            int num = (int) (Math.random() * 9 + 1);
            generatedNumbers.add(num);
        }
        int index = 0;
        for (int num : generatedNumbers) {
            numArr[index++] = num;
        }
    }

    public int[] getNumArr() {
        return numArr;
    }
}

