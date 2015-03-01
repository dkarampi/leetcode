public class Solution {
    public int romanToInt(String s) {

        char [] roman = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int [] numerical = { 1, 5, 10, 50, 100, 500, 1000 };

        if (s.length() == 1)
            return numerical[lookupRomanChar(roman, s.charAt(0))];
        
        int sum = 0;
        int i;
        for (i = 0; i < s.length()-1; i++) {
        	int c = s.charAt(i);
        	if		(c == 'I' && s.charAt(i+1) == 'V') 	{ sum += 4;   i++; }
        	else if (c == 'I' && s.charAt(i+1) == 'X')	{ sum += 9;   i++; }
        	else if (c == 'X' && s.charAt(i+1) == 'L')	{ sum += 40;  i++; }
        	else if (c == 'X' && s.charAt(i+1) == 'C')	{ sum += 90;  i++; }
        	else if (c == 'C' && s.charAt(i+1) == 'D')	{ sum += 400; i++; }
        	else if (c == 'C' && s.charAt(i+1) == 'M')	{ sum += 900; i++; }
        	else {
        		int idx = lookupRomanChar(roman, s.charAt(i));
        		sum += numerical[idx];
        	}
        }
        
        if (i != s.length())
        	sum += numerical[lookupRomanChar(roman, s.charAt(s.length()-1))];
        	
        return sum;
    }
    
    static int lookupRomanChar(char [] roman, char c) {
        for (int i = 0; i < roman.length; i++) {
            if (roman[i] == c)
                return i;
        }
        
        // we should reach this point
        return 0;
    }
}