import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class task1768 {
    /*
    You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
    If a string is longer than the other, append the additional letters onto the end of the merged string.

    Return the merged string.

    Example 1:
    Input: word1 = "abc", word2 = "pqr"
    Output: "apbqcr"
    Explanation: The merged string will be merged as so:
    word1:  a   b   c
    word2:    p   q   r
    merged: a p b q c r

    1 <= word1.length, word2.length <= 100
    word1 and word2 consist of lowercase English letters.
     */

    // my solution
    // runtime: 1ms
    // memory usage: 41.9MB
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.max(word1.length(), word2.length()); i++) {
            if (i > word1.length() - 1) {
                result.append(word2.substring(i));
                break;
            }
            else {
                result.append(word1.charAt(i));
            }
            if (i > word2.length() - 1) {
                result.append(word1.substring(i + 1));
                break;
            }
            else {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }

    @Test
    public void testMySolution() {
        assertEquals("apbqcr", mergeAlternately("abc", "pqr"));
        assertEquals("apbqrs", mergeAlternately("ab", "pqrs"));
        assertEquals("apbqcd", mergeAlternately("abcd", "pq"));
    }
}
