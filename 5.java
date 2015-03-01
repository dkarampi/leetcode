// I check all the possible palindromes inside the string.
// Optimization: I begin from the center of a candidate palindrome and
// expand the search by increasing the left and the right part of the candidate
// by one. Once the new left and right characters do not much, I stop the search.
// I track down the start and the length of the maximum palindrome found so far.

public class Solution {
    public static String longestPalindrome(String s) {
        
        if (s.isEmpty())
            return "";
        
        int maxlen = 1;
        int start = 0;
        
        // check the odd length palindromes
        for (int i = 1; i < s.length()-1; i++) {
            int len = 1;
            int tmp = i; // this initial value shouldn't matter
            for (int pivot = 1; i - pivot >= 0 && i + pivot < s.length(); pivot++) {
                if (s.charAt(i-pivot) != s.charAt(i+pivot))
                    break;
                len = 2*pivot + 1;
                tmp = i - pivot;
            }
            
            if (len > maxlen) {
                maxlen = len;
                start = tmp;
            }
        }
        
        // check the even length palindromes
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) != s.charAt(i+1))
                continue;
            int len = 2;
            int tmp = i;
            for (int pivot = 1; i - pivot >= 0 && i + 1 + pivot < s.length(); pivot++) {
                if (s.charAt(i-pivot) != s.charAt(i+1+pivot))
                    break;
                len = 2*pivot + 2;
                tmp = i - pivot;
            }
            
            if (len > maxlen) {
                maxlen = len;
                start = tmp;
            }
        }

        return s.substring(start, start + maxlen);
    }
}