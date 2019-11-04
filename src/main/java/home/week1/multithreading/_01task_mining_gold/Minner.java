package home.week1.multithreading._01task_mining_gold;

public class Minner extends Thread{

    private IMine mine;

    public Minner(IMine mine) {
        this.mine = mine;
    }

    @Override
    public void run() {
        try {
            while (mine.getCount() != 0 || !isInterrupted()){
                System.out.printf("I minning. Minner # %s, %s\n", getId(), getState());
                sleep(1000);
                mine.mining();
                if (mine.getCount() == 0){
                    System.out.printf("Yeah! Mine is empty. I am free! Minner # %s\n" , getId());
                    interrupt();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            interrupt();
        }
    }
}

