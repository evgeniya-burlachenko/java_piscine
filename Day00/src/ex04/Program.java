package ex04;

import java.util.Scanner;

public class Program {

    public static void ErrorExit(Scanner scan) {
        scan.close();
        System.err.println("Illegal Argument");
        System.exit(-1);
    }
    public static void PrintDiagramm(long results) {

        long countOfWeek = 1;

        for (; results / countOfWeek > 10; countOfWeek *= 10)
            ;

        for (int week = 1; results != 0; week++, countOfWeek /= 10) {

            long i = results / countOfWeek;
//            System.out.println("i");
//            System.out.println(i);
            System.out.print("Week " + week + " ");
            for (int equal = 1; equal <= i; equal++) {
                System.out.print("=");
//                System.out.println("i2");
//                System.out.println(i);
            }
            System.out.println(">");
            results = results - countOfWeek * i;
            System.out.println("countOfWeek");
                System.out.println(countOfWeek);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long resultsArray = 0;

        for (int week = 1; week < 19; week++) { //основной цикл

            int minGrade = 10; //

            String str = scanner.next(); //до пробела 42 или week

            if (str.equals("42")) {
                PrintDiagramm(resultsArray);
//                System.out.println("resultsArray");
//                System.out.println(resultsArray);
                break;
            } else if (!str.equals("Week")) {
                ErrorExit(scanner);
            }
     //-------------------------------------------------------------
            if (week != scanner.nextInt()){//проверка чтобы после week была цифра перед 42???????
//                System.out.println("week");
//                System.out.println(week);
                ErrorExit(scanner);
            }
            for (int i = 0; i < 5; i++) { // для оценок цикл 5 раз
                if (!scanner.hasNextInt()) {
                    ErrorExit(scanner);
                }
               int newGrade = scanner.nextInt();//считываю инты до пробела
                if (newGrade < 1 || newGrade > 9) { //проверка  оценки
                    ErrorExit(scanner);
                }
                if (minGrade > newGrade) { //таким образом сюжа попадает только 1 grade - самый маленький
                    minGrade = newGrade;
                }
            }

          resultsArray = resultsArray * 10 + minGrade; // для диаграммы хранятся все минимаольные
//            System.out.println("resultsArrayend");
//            System.out.println(resultsArray);
            if (week == 18) { //для выхода из программы после 18 недели, что бы появилась диаграмма
                PrintDiagramm(resultsArray);
                break;
            }
        }
        scanner.close();
    }
}
