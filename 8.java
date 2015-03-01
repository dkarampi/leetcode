public class Solution {
    public int atoi(String str) {
        
        // remove all leading or trailing whitespaces
        str = str.trim();
        
        if (str.isEmpty())
            return 0;
        
        // take care of the sign
        int negative = 1;
        if (str.charAt(0) == '+')
            str = str.substring(1);
        else if (str.charAt(0) == '-') {
            str = str.substring(1);
            negative = -1;
        }
        
        // make sure the input is not any of "-" or "+"
        if (str.isEmpty())
            return 0;
        
        // verify that the first character is a numeric one
        if (str.charAt(0) < '0' || str.charAt(0) > '9')
            return 0;
            
        long result = 0L;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') // ignore trailing characters
                return (int) result * negative;
                
            result *= 10;
            result += (c - '0');
            
            // check for overflow
            if (negative == 1 && result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (negative == -1 && -result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        
        return (int) result * negative;
    }
}