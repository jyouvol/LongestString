package org.test.program;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

public class LongestWordFinderTest {

    private LongestWordFinder longestWordFinder;

    @Before
    public void setup() {
        this.longestWordFinder = new LongestWordFinder();
    }

    @Test
    public void locateLongestWordFromReturnsOptionalEmpty() {
        assertFalse(longestWordFinder.locateLongestWordFrom(null).isPresent());
    }

    @Test
    public void locateLongestWordFromReturnsReturnsOptionalEmptyOnEmptyInputString() {
        assertFalse(longestWordFinder.locateLongestWordFrom("").isPresent());
    }

    @Test
    public void locateLongestWordFromReturnsExpectedLongestWord() {
        String longestString = "California";
        String input = "NewYork Miami Chicago LosAngeles Tampa ".concat(longestString);
        Optional<Set<String>> strings = longestWordFinder.locateLongestWordFrom(input);
        assertNotNull(strings);
        assertTrue(strings.isPresent());
        assertTrue(strings.get().contains(longestString));
        assertFalse(strings.get().contains("NewYork"));
    }

    @Test
    public void locateLongestWordFromReturnsExpectedWords() {
        //both strings of same length expect both in result
        String longestString1 = "California";
        String longestString2 = "SaintLouis";

        String input = "NewYork Missouri Florida LosAngeles ".concat(longestString1).concat(" ").concat(longestString2);

        Optional<Set<String>> strings = longestWordFinder.locateLongestWordFrom(input);
        assertNotNull(strings);
        assertTrue(strings.isPresent());
        assertTrue(strings.get().contains(longestString1));
        assertTrue(strings.get().contains(longestString2));
    }

    @Test
    public void locateLongestWordHandlesUnexpectedChars() {
        String longestString1 = "$%^@%%%%%!!!&&&7464975";
        String longestString2 = "12344675";

        String input = "NewYork Missouri ".concat(longestString1).concat(" ").concat(longestString2);

        Optional<Set<String>> strings = longestWordFinder.locateLongestWordFrom(input);
        assertNotNull(strings);
        assertTrue(strings.isPresent());
        assertTrue(strings.get().contains(longestString1));
        assertFalse(strings.get().contains(longestString2));
    }
}