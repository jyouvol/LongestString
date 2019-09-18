package org.test.program;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LongestWordFinderTest {


    private LongestWordFinder longestWordFinder;

    @Before
    public void setup() {
        this.longestWordFinder = new LongestWordFinder();
    }

    @Test
    public void locateLongestWordFromReturnsNullOnNullInput() {
        assertNull(longestWordFinder.locateLongestWordFrom(null));
    }

    @Test
    public void locateLongestWordFromReturnsEmptyStringOnEmptyInputString() {
        assertEquals("", longestWordFinder.locateLongestWordFrom(""));
    }

    @Test
    public void locateLongestWordFromReturnsExpectedLongestWord() {
        String longestString = "California";
        String input = "NewYork Miami Chicago LosAngeles Tampa ".concat(longestString);
        assertEquals(longestString, longestWordFinder.locateLongestWordFrom(input));
    }

    @Test
    public void locateLongestWordFromReturnsExpectedLastLongestWordWithMultipleWordsOfSameSize() {
        //both strings of same length expect SaintLouis
        String longestString1 = "California";
        String longestString2 = "SaintLouis";

        String input = "NewYork Missouri Florida LosAngeles ".concat(longestString1).concat(" ").concat(longestString2);

        assertEquals(longestString2, longestWordFinder.locateLongestWordFrom(input));
    }
}