package org.test.program;

public class LongestWordFinder {

    public static void main(String[] args) {
        LongestWordFinder finder = new LongestWordFinder();

        String input = getInput(args);
        String longestWord = finder.locateLongestWordFrom(input);
        if (longestWord == null || longestWord.isEmpty()) {
            System.out.println("Invalid input");
        } else {
            System.out.println(String.format("%d %s", longestWord.length(), longestWord));
        }
    }


    /**
     * This method takes an input as string value to extract longest word
     * Assumption is string is not null and has at least one Character
     * This method returns the last computed longest word
     *
     * @param input
     * @return last computed longest word
     */

    public String locateLongestWordFrom(String input) {

        if (null == input) {
            return null;
        }
        if (input.isEmpty()) {
            return input;
        }

        String longestWord = "";
        StringBuilder cache = new StringBuilder();
        int longestWordLength = 0;
        int currentWordLength = 0;

        for (Character c : input.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                cache.append(c);
                currentWordLength++;
            } else {
                if (currentWordLength > longestWordLength) {
                    longestWordLength = currentWordLength;
                    longestWord = cache.toString();
                }
                cache = new StringBuilder();
                currentWordLength = 0;

            }
        }
        if (currentWordLength >= longestWordLength) {
            longestWord = cache.toString();
        }
        return longestWord;
    }

    private static String getInput(String[] args) {
        if (args == null || args.length == 0) {
            return null;
        } else {
            return args[0];
        }
    }
}
