package BaseballHW.oop2;

import java.util.ArrayList;
import java.util.List;

public // GameRecord 클래스 (게임 기록 관리)
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
