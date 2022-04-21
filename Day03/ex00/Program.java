package ex00;

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
        newThreads Egg = new newThreads(count, "Egg");
        newThreads Hen = new newThreads(count, "Hen");

        Egg.start();
        Hen.start();

        try {
            Egg.join();
            Hen.join();
        } catch (InterruptedException e) {
            System.err.println("Error: not join");
            System.exit(-1);
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
