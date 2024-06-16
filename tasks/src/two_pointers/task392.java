package two_pointers;

import org.junit.Test;

import java.util.Arrays;

public class task392 {
    /*
    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string by deleting some
     (can be none) of the characters without disturbing the relative positions of the remaining characters.
     (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



    Example 1:

    Input: s = "abc", t = "ahbgdc"
    Output: true

    Example 2:

    Input: s = "axc", t = "ahbgdc"
    Output: false



    Constraints:

        0 <= s.length <= 100
        0 <= t.length <= 104
        s and t consist only of lowercase English letters.

    s = "axc", t = "ahbgdc"
     */

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.isEmpty()) return true;
        int j=0;
        for (int i = 0; i<t.length(); i++) {
            for (int k = i; k<t.length(); k++) {
                if (t.charAt(k)==s.charAt(j)){
                    j++;
                }
                if (j==s.length()) return true;
            }
            j=0;
        }
        return false;
    }

    @Test
    public void test() {
        assert(!isSubsequence("axc", "ahbgdc"));
        assert(isSubsequence("abc", "ahbgdc"));
        assert(isSubsequence("", "ahbgdc"));
        assert(isSubsequence("", ""));
        assert(!isSubsequence("abc", ""));
    }
}
