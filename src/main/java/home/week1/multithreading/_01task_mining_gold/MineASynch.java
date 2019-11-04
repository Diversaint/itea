package home.week1.multithreading._01task_mining_gold;

import java.util.ArrayList;
import java.util.List;

public class MineASynch implements IMine {

    private volatile int gold;

    public MineASynch(int gold) {
        this.gold = gold;
    }

    @Override
    public void mining() {
        if (gold <= 3){
            //System.out.println("Mine is empty");
            gold = 0;
        } else gold = gold - 3;
    }

    @Override
    public int getCount() {
        return gold;
    }
}
