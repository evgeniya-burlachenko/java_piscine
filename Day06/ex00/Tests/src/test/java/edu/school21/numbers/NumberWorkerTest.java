package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {
    private final NumberWorker numberWorker = new NumberWorker();

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 101, 809, 61, 79})
    public void isPrimeForPrimes(int number) {
        assertTrue(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 100, 38, 2000, 5000})
    public void isPrimeForNotPrimes(int number){
        assertFalse(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -5, -100, -5000})
    public void isPrimeForIncorrectNumbers(int number) {
        assertThrows(IllegalNumberException.class, () -> numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources =  {"/data.csv"}, delimiter = ',')
    public void checkDigitSum(int x, int y) {
        assertEquals(y, numberWorker.digitsSum(x));
    }
}
