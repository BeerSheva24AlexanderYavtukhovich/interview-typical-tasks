package telran.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import static telran.interview.InterviewTasks.hasSumTwo;

public class InterviewTasksTest {
    @Test
    void hasSumTwoTest() {
        assertTrue(hasSumTwo(new int[] { 10, 15, 3, 7 }, 17));
        assertFalse(hasSumTwo(new int[] { 10, 15, 3, 7 }, 20));
        assertFalse(hasSumTwo(new int[] {}, 5));
        assertFalse(hasSumTwo(new int[] { 5 }, 10));
        assertTrue(hasSumTwo(new int[] { 1, 2, 3, 4, 5, 6 }, 10));
        assertTrue(hasSumTwo(new int[] { -1, -2, -3, -4 }, -5));
        assertTrue(hasSumTwo(new int[] { -1, 2, 3, 4, -2 }, 1));
    }
}
