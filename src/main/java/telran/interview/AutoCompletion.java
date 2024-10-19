package telran.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoCompletion {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
        String word = null;
    }

    private final TrieNode root;

    public AutoCompletion() {
        root = new TrieNode();
    }

    public boolean addWord(String word) {
        TrieNode node = root;
        boolean wasEndOfWord = false;

        for (char ch : word.toLowerCase().toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }

        wasEndOfWord = node.isEndOfWord;

        if (!wasEndOfWord) {
            node.isEndOfWord = true;
            node.word = word;
        }
        return !wasEndOfWord;
    }

    public String[] getVariants(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            node = node.children.get(c);
        }
        if (node != null) {
            collectAllWords(node, results);
        }
        return results.toArray(String[]::new);
    }

    private void collectAllWords(TrieNode node, List<String> results) {
        if (node.isEndOfWord) {
            results.add(node.word);
        }
        node.children.forEach((character, childNode) -> collectAllWords(childNode, results));
    }
}
