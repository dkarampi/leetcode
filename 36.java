// I assume an arbitrary size of the board. According to the
// rules we need to check that all lines, columns and individual
// squares have distinct values. I should also check maybe that
// all numbers lie between 0 <= k <= len.
// A HashSet (a Bitmap could also be used) to do the checks in linear
// time. For correctness, reset the HashSet after every use.

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int len = board.length;
        
        Set set = new HashSet();
        // check rows
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                
                if (board[i][j] == '.')
                    continue;
                
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
            set = new HashSet();
        }
        
        set = new HashSet();
        // check columns
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < len; i++) {
                
                if (board[i][j] == '.')
                    continue;
                
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
            set = new HashSet();
        }
        
        set = new HashSet();
        // check individual squares
        int padding = (int) Math.sqrt(len);
        for (int m = 0; m < len; m += padding) {
            for (int n = 0; n < len; n += padding) {
                for (int i = m; i < m+padding; i++) {
                    for (int j = n; j < n+padding; j++) {
                        
                        if (board[i][j] == '.')
                            continue;
                        
                        if (set.contains(board[i][j]))
                            return false;
                        set.add(board[i][j]);
                    }
                }
                set = new HashSet();
            }
        }

        return true;
    }
}