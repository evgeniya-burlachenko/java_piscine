package ex01;


public class Program {
    public static void printError() {
        System.err.println("Usage: java Program --count=[count] && count positive");
        System.exit(-1);
    }

    public static void main(String[] args)
            throws InterruptedException {
        int count = 0;
        if (1 != args.length || !args[0].startsWith("--count=")) {
            printError();
        }
        //count = Integer.parseInt(args[0].substring(8));
        if (args[0].substring(8) != "") {
            count = Integer.parseInt(args[0].substring(8));
        }
        else {
            System.err.println("Error: count incorrect");
            System.exit(-1);
        }
        if (count < 1) {
            printError();
        }

        // Object of a class that has both produce()
        // and consume() methods
        final Producer pc = new Producer();
        int finalCount = count;
        // Create producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.produce_egg(finalCount);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consume_hen(finalCount);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();

    }
}
