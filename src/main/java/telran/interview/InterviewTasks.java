package telran.interview;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class InterviewTasks {
    public static boolean hasSumTwo(int[] array, int sum) {
        Set<Integer> checked = new HashSet<>();
        return IntStream.of(array)
                .anyMatch(num -> checked.contains(sum - num) || (checked.add(num) && false));
    }
}
