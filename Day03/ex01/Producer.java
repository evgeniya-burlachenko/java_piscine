package ex01;
import java.util.LinkedList;
//https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/
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

    // notifies the consumer thread that
    // now it can start consuming


    // Function called by consumer thread
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
