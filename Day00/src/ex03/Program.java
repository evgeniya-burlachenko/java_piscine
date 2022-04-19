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
            remainder = remainder * 10;//здесь будет самое большое число  - максимум с 18 нулями

        while (i < countOfWeek) {
            //разбиваю res на десятки сотни и тд 1 2 3 4 5 6
            long sign = res / remainder;
            System.out.print("Week " + i + " ");
            for (int j = 0; j < sign; ++j)
                System.out.print("=");//столько = сколько res
            System.out.println(">");
            res = res - sign * remainder; //сокращаю res на первую цифру
            remainder /= 10;// убираю 1 ноль и запускаю цикл опять
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
            //проверка week #
            if (!"Week".equals(s)) {
                ErrorExit(scanner);
            }
            //проверка что после week точно int
            if (!scanner.hasNextInt()) {
                ErrorExit(scanner);
            }
            int tmp = scanner.nextInt();
            if (countOfWeek != tmp) { ///проверка на порядок week 1  week 2 week 3 и тд
                ErrorExit(scanner);
            }
            //проверка grade (от 1 до 9, 5 чисел)
            while (countOfGrade <= 5) {
                if (!scanner.hasNextInt()) { //проверка на число
                    ErrorExit(scanner);
                }
                int inputNum = scanner.nextInt();
                if (countOfGrade == 1)
                {
                    minNum = inputNum;
                }
                else {
                    if ( minNum > inputNum ) { //таким образом сюжа попадает только 1 grade - самый маленький
                        minNum = inputNum;
                        //minNum = (minNum < inputNum) ? minNum: inputNum;
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