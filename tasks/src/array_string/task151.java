package array_string;

import org.junit.Test;

import java.util.List;

public class task151 {
    /*
    Given an input string s, reverse the order of the words.
    A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
    Return a string of the words in reverse order concatenated by a single space.
    Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

    Example 1:
    Input: s = "the sky is blue"
    Output: "blue is sky the"

    Example 2:
    Input: s = "  hello world  "
    Output: "world hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.

    Example 3:
    Input: s = "a good   example"
    Output: "example good a"
    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

    Constraints:

    1 <= s.length <= 104
    s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    There is at least one word in s.
     */

    public String reverseWords(String s) {
        StringBuffer result = new StringBuffer();

        String[] words = s.split(" ");

        for (int i = words.length-1; i >= 0; i--) {
            if (words[i].length() > 0) {
                result.append(words[i]);
                result.append(" ");
            }
        }

        return result.substring(0, result.length()-1);
    }

    @Test
    public void test() {
        assert(reverseWords("the sky is blue").equals("blue is sky the"));
        assert(reverseWords("  hello world  ").equals("world hello"));
        assert(reverseWords("a good   example").equals("example good a"));
    }
}
