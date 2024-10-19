package telran.interview;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewTasks {
    public static boolean hasSumTwo(int[] array, int sum) {
        Set<Integer> checked = new HashSet<>();
        return IntStream.of(array)
                .anyMatch(num -> checked.contains(sum - num) || (checked.add(num) && false));
    }

    public static int getMaxWithNegativePresentation(int[] array) {
        Set<Integer> values = new HashSet<>();
        int max = -1;
        for (int num : array) {
            if (values.contains(-num)) {
                max = Math.max(max, Math.abs(num));
            }
            values.add(num);
        }
        return max;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
            List<LocalDate> dates) {
        if (rolesHistory == null || rolesHistory.isEmpty() || dates == null || dates.isEmpty()) {
            return Collections.emptyList();
        }
        TreeMap<LocalDate, String> roles = rolesHistory.stream()
                .collect(Collectors.toMap(DateRole::date, DateRole::role, (e1, e2) -> e1, TreeMap::new));
        List<DateRole> res = new ArrayList<>(dates.size());
        for (LocalDate date : dates) {
            String role = roles.floorEntry(date) != null ? roles.floorEntry(date).getValue() : null;
            res.add(new DateRole(date, role));
        }
        return res;
    }

    public static boolean isAnagram(String word, String anagram) {
        return word.length() == anagram.length()
            && !word.equals(anagram)
            && word.chars()
                   .mapToObj(c -> (char) c)
                   .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                   .equals(anagram.chars()
                                  .mapToObj(c -> (char) c)
                                  .collect(Collectors.groupingBy(c -> c, Collectors.counting())));
    }
}
