public class newThreads extends Thread {

    int count = 0;
    String name = "";

    public newThreads(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public  void run() {
        for (int i = 0; i < count; i++){
            System.out.println(name);
            try {
                Thread.sleep(100, 0);
            } catch (Exception e) {
                System.err.println("Error: sleep");
                System.exit(-1);
            }
        }
    }
}
