package home.week1.multithreading._01task_mining_gold;

import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void main(String[] args) {

        IMine mine = new MineASynch(100);
        List<Thread> minners = new ArrayList<>();


        for (int i = 0; i < 5; i++){
            Thread minner = new Minner(mine);
            minner.start();
            minners.add(minner);
            }

        Thread minnerFactory = new MinnerFactory(mine);
        minnerFactory.start();

        for (Thread minner : minners) {
            try {
                minner.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }





        try {
            minnerFactory.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    static class MinnerFactory extends Thread{
        private IMine mine;

        public MinnerFactory( IMine mine) {
            this.mine = mine;
        }

        @Override
        public void run() {
            try {
                while (mine.getCount() != 0){
                    sleep(5000);
                    Thread minner = new Minner(mine);
                    minner.start();
                    System.out.println("Created new worker");
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
