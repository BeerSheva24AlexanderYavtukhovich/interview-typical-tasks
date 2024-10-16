package telran.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import static telran.interview.InterviewTasks.hasSumTwo;

public class InterviewTasksTest {
    @Test
    void hasSumTwoTest() {
        assertTrue(hasSumTwo(new int[] { 10, 15, 3, 7 }, 17));
        assertTrue(hasSumTwo(new int[] { 10, 10, 15, 3, 7 }, 17));
        assertTrue(hasSumTwo(new int[] { 10, 15, 3, 7, 3 }, 17));
        assertFalse(hasSumTwo(new int[] { 10, 15, 3, 7 }, 20));
        assertFalse(hasSumTwo(new int[] {}, 5));
        assertFalse(hasSumTwo(new int[] { 5 }, 10));
        assertFalse(hasSumTwo(new int[] { 1, 2, 3, 10, 10 }, 8));
        assertTrue(hasSumTwo(new int[] { 1, 2, 3, 4, 5, 6 }, 10));
        assertTrue(hasSumTwo(new int[] { -1, -2, -3, -4 }, -5));
        assertTrue(hasSumTwo(new int[] { -1, 2, 3, 4, -2 }, 1));
    }

    @Test
    void hasSumTwoTeacherTest() {
        int sum1 = 8;
        int sum2 = Integer.MIN_VALUE;
        int[] arTrue1 = { 1, 2, 3, 4, 4 };
        int[] arTrue2 = { 1, 2, 3, 4, Integer.MAX_VALUE };
        int[] arFalse = { 1, 2, 3, 10, 10 };
        assertTrue(InterviewTasks.hasSumTwo(arTrue1, sum1));
        assertTrue(InterviewTasks.hasSumTwo(arTrue2, sum2));
        assertFalse(InterviewTasks.hasSumTwo(arFalse, sum1));
    }
}
