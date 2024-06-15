package array_string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class task345 {
    /*
    Given a string s, reverse only all the vowels in the string and return it.
    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.


    Example 1:
    Input: s = "hello"
    Output: "holle"

    Example 2:
    Input: s = "leetcode"
    Output: "leotcede"

    Constraints:

        1 <= s.length <= 3 * 105
        s consist of printable ASCII characters.
     */

    // Runtime 5ms
    public String reverseVowels(String s) {
        if (s.isEmpty()) return s;
        if (s.isBlank()) return s;

        List<Character> vowels = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char y = s.charAt(i);
            if (y == 'a' || y == 'e' || y == 'i' || y == 'o'
                    || y == 'u' || y == 'A' || y == 'E' || y == 'I'
                    || y == 'O' || y == 'U') {
                vowels.add(y);
            }
        }
        int j = vowels.size() - 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char y = s.charAt(i);
            if (y == 'a' || y == 'e' || y == 'i' || y == 'o'
                    || y == 'u' || y == 'A' || y == 'E' || y == 'I'
                    || y == 'O' || y == 'U') {
                result.append(vowels.get(j));
                j--;
            }
            else result.append(y);
        }
        return result.toString();
    }

    @Test
    public void test(){
        assert(reverseVowels("hello").equals("holle"));
        assert(reverseVowels("leetcode").equals("leotcede"));
    }
}
