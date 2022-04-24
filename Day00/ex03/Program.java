package ex03;
import java.util.Scanner;

public class Program {

    public static void ErrorExit(Scanner scan) {
        scan.close();
        System.err.println("Illegal Argument");
        System.exit(-1);
    }
    public static void printDiagram(int countOfWeek, long res) {
        int i = 1;

        long remainder = 1;

        for (int j = 1; j < countOfWeek - 1; ++j)
            remainder = remainder * 10;

        while (i < countOfWeek) {
            long sign = res / remainder;
            System.out.print("Week " + i + " ");
            for (int j = 0; j < sign; ++j)
                System.out.print("=");
            System.out.println(">");
            res = res - sign * remainder;
            remainder /= 10;
            i++;
        }
    }

    public static void main(String args[]) {
        int countOfWeek = 1;

        int countOfGrade = 1;

        int minNum = 0;

        long resultArray = 0;

        Scanner scanner = new Scanner(System.in);

        while (countOfWeek <= 18) {
            String s = scanner.next();
            if ("42".equals(s)) {
                printDiagram(countOfWeek, resultArray);
                System.exit(0);
            }
            if (!"Week".equals(s)) {
                ErrorExit(scanner);
            }
            if (!scanner.hasNextInt()) {
                ErrorExit(scanner);
            }
            int tmp = scanner.nextInt();
            if (countOfWeek != tmp) {
                ErrorExit(scanner);
            }
            while (countOfGrade <= 5) {
                if (!scanner.hasNextInt()) {
                    ErrorExit(scanner);
                }
                int inputNum = scanner.nextInt();
                if (countOfGrade == 1)
                {
                    minNum = inputNum;
                }
                else {
                    if ( minNum > inputNum ) {
                        minNum = inputNum;
                    }
                }
                countOfGrade++;
            }
            countOfGrade = 1;
            resultArray = resultArray * 10 + minNum;
            countOfWeek++;
        }
        printDiagram(countOfWeek, resultArray);
        System.exit(0);
    }
}
