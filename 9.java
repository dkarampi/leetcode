public class Solution {
    public boolean isPalindrome(int x) {
        
        // seems that negative numbers are not palindromes
        if (x < 0)
            return false;
            
        // reverse the number
        long reversed = 0L;
        int tmp = x;
        while (tmp > 0) {
            int digit = tmp % 10;
            reversed *= 10;
            reversed += digit;
            
            if (reversed > Integer.MAX_VALUE)
                return false;
                
            tmp /= 10;
        }
        
        return (x == (int) reversed);
    }
}