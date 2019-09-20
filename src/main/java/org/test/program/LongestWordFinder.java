package org.test.program;

import java.util.*;

public class LongestWordFinder {

    public static void main(String[] args) {
        LongestWordFinder finder = new LongestWordFinder();

        String input = getInput(args);
        Optional<Set<String>> mayLongestWords = finder.locateLongestWordFrom(input);
        if (!mayLongestWords.isPresent()) {
            System.out.println("Invalid input");
        } else {
            Set<String> longestWords = mayLongestWords.get();
            System.out.println(String.format("Number of words found: %d; Words: [ %s ]", longestWords.size(), String.join(", ", longestWords)));
        }
    }


    /**
     * This method takes an input as string value to extract longest word(s)
     * Assumption is string is not null and has at least one Character
     * This method returns all the computed longest word(s) eliminating the repeated words
     *
     * @param input
     * @return computed words
     */

    public Optional<Set<String>> locateLongestWordFrom(String input) {

        if (null == input || input.isEmpty()) {
            return Optional.empty();
        }

        Set<String> longestWords = new HashSet<>();
        List<Character> currentWordCache = new ArrayList<>();

        String longestWord;
        int longestWordLength = 0;
        int currentWordLength = 0;

        for (Character c : input.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                currentWordCache.add(c);
                currentWordLength++;
            } else {
                if (currentWordLength >= longestWordLength) {
                    if (currentWordLength > longestWordLength) {
                        longestWords.clear();
                        longestWordLength = currentWordLength;
                    }
                    longestWord = this.charListToString(currentWordCache);
                    longestWords.add(longestWord);
                }
                currentWordCache.clear();
                currentWordLength = 0;
            }
        }

        if (!currentWordCache.isEmpty()) {
            if (currentWordCache.size() >= longestWordLength) {
                if (currentWordCache.size() > longestWordLength) {
                    longestWords.clear();
                }
                longestWord = this.charListToString(currentWordCache);
                longestWords.add(longestWord);
            }
        }
        return Optional.of(longestWords);
    }

    private String charListToString(List<Character> cache) {
        char[] chars = new char[cache.size()];
        for (int index = 0; index < cache.size(); index++) {
            chars[index] = cache.get(index);
        }
        return new String(chars);
    }

    private static String getInput(String[] args) {
        if (args == null || args.length == 0) {
            return null;
        } else {
            return args[0];
        }
    }
}
