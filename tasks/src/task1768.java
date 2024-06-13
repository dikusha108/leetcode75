import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class task1768 {
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
    public void test() {
        assertEquals("apbqcr", mergeAlternately("abc", "pqr"));
        assertEquals("apbqrs", mergeAlternately("ab", "pqrs"));
        assertEquals("apbqrs", mergeAlternately("ab", "pqrs"));
    }
}
