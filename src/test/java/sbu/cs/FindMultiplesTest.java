package java.sbu.cs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FindMultiplesTest {
    private static FindMultiples findMultiples;

    @BeforeAll
    static void setup() {
        findMultiples = new FindMultiples();
    }

    @Test
    void testOne() throws InterruptedException {
        int n = 9;
        int target_sum = 30;
        assertEquals(target_sum, findMultiples.getSum(n));
    }

    @Test
    void testTwo() throws InterruptedException {
        int n = 15;
        int target_sum = 81;
        assertEquals(target_sum, findMultiples.getSum(n));
    }

    @Test
    void testThree() throws InterruptedException {
        int n = 1000;
        int target_sum = 272066;
        assertEquals(target_sum, findMultiples.getSum(n));
    }

    @Test
    void testFour() throws InterruptedException {
        int n = 58;
        int target_sum = 964;
        assertEquals(target_sum, findMultiples.getSum(n));
    }

    @Test
    void testFive() throws InterruptedException {
        int n = 76293;
        int target_sum = 1579905952;
        assertEquals(target_sum, findMultiples.getSum(n));
    }

    @Test
    void testSix() throws InterruptedException {
        int n = 1;
        int target_sum = 0;
        assertEquals(target_sum, findMultiples.getSum(n));
    }

}
