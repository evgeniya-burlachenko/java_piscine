import java.util.Scanner;

public class Program {
    public static boolean isItPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (0 == num % i) {
                return (false);
            }
        }
        return (true);
    }

    public static void main(String[] args) {
        int iter = 0;
        int input;
        int res = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (!scanner.hasNextInt()) {
                System.exit(-1);
            }
            input = scanner.nextInt();
            if (42 == input) {
                break;
            }
            while (input != 0) {
                res += input % 10;
                input = input / 10;
            }
            if (isItPrime(res)) {
                iter++;
            }
        }
        System.out.println("Count of coffee-request - " + iter);
        scanner.close();
    }
}
