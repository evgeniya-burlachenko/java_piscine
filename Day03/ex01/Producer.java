import java.util.LinkedList;

public class Producer extends  Thread {

    int flag = 0;

    public void produce_egg(int count) throws InterruptedException {
        for (int i = 0; i < count; i++){
            synchronized (this) {
                if (flag == 1)
                    wait();
                System.out.println("Egg");
                flag = 1;
                notify();

                Thread.sleep(300);
            }
        }
    }

    public void consume_hen(int count) throws InterruptedException {
        for (int i = 0; i < count; i++){
            synchronized (this) {
                if (flag == 0)
                    wait();
                System.out.println("Hen");
                notify();
                flag = 0;
                Thread.sleep(300);
            }
        }
    }
}
