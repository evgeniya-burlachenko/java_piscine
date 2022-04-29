package edu.school21.numbers;

class IllegalNumberException extends RuntimeException {
}
public class NumberWorker {
    public static boolean isPrime(int number) {
        if (number <= 1)
            throw new IllegalNumberException();
        for (int i = 2; i * i <= number; i++) {
            if (0 == number % i) {
                return (false);
            }
        }
        return (true);
    }

    public int digitsSum(int number) {
        int sum = 0;
        while (number > 0) {
            int tmp = number % 10;
            sum += tmp;
            number /= 10;
        }
        return sum;
    }
}
