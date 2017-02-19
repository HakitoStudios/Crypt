package ua.nure.havrysh;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TextStatistics {
    private static final double HUNDRED_PERCENTS = 100;

    public enum Order {
        ALPHABETICAL((e1, e2) -> e1.getKey().compareTo(e2.getKey())),
        FREQUENCY((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        private Comparator<Map.Entry<Character, Integer>> comparator;

        Order(Comparator<Map.Entry<Character, Integer>> comparator) {
            this.comparator = comparator;
        }

        public Comparator<Map.Entry<Character, Integer>> getComparator() {
            return comparator;
        }
    }

    public void analyzeLettersFrequency(String s, boolean ignoreCase, Order order) {
        Map<Character, Integer> frequencies = new HashMap<>();
        s.chars().forEach(c -> {
            char ch = ignoreCase ? Character.toLowerCase((char) c) : (char) c;
            Integer freq = frequencies.get(ch);
            frequencies.put(ch, freq == null ? 1 : freq + 1);
        });
        frequencies.entrySet()
                .stream()
                .sorted(order.getComparator())
                .forEach(e -> printLetterStatistics(e, s.length()));
    }

    private void printLetterStatistics(Map.Entry<Character, Integer> e, int textLength) {
        System.out.printf("%s === %d   %f%%%n", e.getKey(), e.getValue(), HUNDRED_PERCENTS * e.getValue() / textLength);
    }
}