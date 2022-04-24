import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (false == scanner.hasNextInt()) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        int num = scanner.nextInt();
        if (num < 2) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        else if(num == 2){
            System.out.println("true 0");
        }

        int iter = 1;

        for (int i = 2; i * i <= num; i++, iter++){
            if (0 == num % i) {
                System.out.println("false " + iter);
                System.exit(0);
            }
        }
        System.out.println("true " + iter);
        scanner.close();
    }
}
