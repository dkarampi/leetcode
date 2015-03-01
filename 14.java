public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        
        String s = strs[0];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i+1 || strs[j].charAt(i) != c)
                    return s.substring(0, i);
            }
        }
        
        return s;
    }
}