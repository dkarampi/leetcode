public class Solution {
    public int reverse(int x) {
        
        long result = 0L;
        long xl = (long) x;
        
        boolean negative = false;
        if (x < 0) {
            negative = true;
            xl = -xl;
        }
        
        while (xl > 0) {
            long digit = xl % 10;
            result *= 10;
            result += digit;
            
            if (result > (long) Integer.MAX_VALUE)
                return 0;
            
            xl /= 10;
        }
        
        if (negative)
            return (int) -result;
        
        return (int) result;
    }
}