import java.util.Random;
import java.util.Vector;

public class Program {

    private static int sumOfThreads;

    static class MultiThreading {
        int sumOfIntInArray = 0;
        int[] arr;

        public void generateArray(int arrSize) {
            Random rd = new Random();
            arr = new int[arrSize];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rd.nextInt(1000);
                sumOfIntInArray += arr[i];
            }
        }
        public int getSumOfIntInArray() {
            return sumOfIntInArray;
        }
        public int[] getArr() {
            return arr;
        }
    }

    static class RealMultithreading extends Thread {

        int id;
        int first;
        int next;
        int[] arr;

        public RealMultithreading(int id, int first, int next, int[] arr) {
            this.id = id;
            this.first = first;
            this.next = next;
            this.arr = arr;
        }

        public void run() {
            int i = first, j = next;
            int sum = 0;
            for (; i < j; ++i) {
                sum += arr[i];
            }
            
            sumOfThreads += sum;
            System.out.println(
                    "Thread " + ++id + ": from " + first + " to " + (next - 1) + " sum is " + sum);
        }
    }
    public static void printError() {
        System.err.println("Usage: java Program --arraySize=[count] --threadsCount=[count] && count positive");
        System.exit(-1);
    }

    public static void main(String[] args)  {
        int arrSize = 0;
        int threadsCount = 0;
        if (2 != args.length ||!args[0].startsWith("--arraySize=") ) {
            printError();
        }
        if (args[0].substring(12) != "") {
            arrSize = Integer.parseInt(args[0].substring(12));
        } else {
            System.err.println("Error: count array incorrect");
            System.exit(-1);
        }
        if (args[1].substring(15) != "") {
            threadsCount = Integer.parseInt(args[1].substring(15));
        } else {
            System.err.println("Error: count incorrect");
            System.exit(-1);
        }
        if (threadsCount < 1 ) {
            printError();
        }

        MultiThreading object = new MultiThreading();
        object.generateArray(arrSize);
        System.out.println("Sum: " + object.getSumOfIntInArray());

        int arr[] = object.getArr();

        int modulo = arrSize % threadsCount;
        int addForNext = arrSize / threadsCount;

        Vector<RealMultithreading> arrayOfThreads = new Vector<>();

        if (modulo != 0) {
            int first = 0, num = 0;
            for (; num < threadsCount - 1; first += addForNext, ++num) {

                arrayOfThreads.add(new RealMultithreading(num, first, first + addForNext, arr));
            }
            arrayOfThreads.add(new RealMultithreading(num, first, arrSize, arr));
        } else {

            for (int first = 0, num = 0; num < threadsCount; first += addForNext, ++num) {
                arrayOfThreads.add(new RealMultithreading(num, first, first + addForNext, arr));
            }
        }
        for (RealMultithreading curThread: arrayOfThreads){
            curThread.start();
        }

        for (RealMultithreading curThread: arrayOfThreads) {
            try {
                curThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum by threads: " + sumOfThreads);
    }
}
