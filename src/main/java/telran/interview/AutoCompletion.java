package telran.interview;

import java.util.TreeSet;

public class AutoCompletion {
    private final TreeSet<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public boolean addWord(String word) {
        return words.add(word);
    }

    public String[] getVariants(String prefix) {
        return words.subSet(prefix, prefix + Character.MAX_VALUE).toArray(new String[0]);
    }
}
