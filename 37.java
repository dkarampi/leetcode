// Breadth first search at the solution space using backtracking
public class Solution {
    
    public static final int DIM = 9; // board's dimension
    
    public void solveSudoku(char[][] board) {
        
        // ignore the return value
        sudokuSolution(board, 0, 0);
        
        return;
    }
    
    private boolean sudokuSolution(char[][] board, int row, int col) {
        
        // DONE!
        if (row == DIM)
            return true;
        
        int nextr = col+1 == DIM ? row+1 : row;
        int nextc = (col+1) % DIM;
        
        if (board[row][col] != '.') {
            return sudokuSolution(board, nextr, nextc);
        }
        
        for (char k = '1'; k <= '9'; k++) { // Note: This is DIM dependant
            board[row][col] = k;
            if (isValidSetup(board, row, col)) {
                if (sudokuSolution(board, nextr, nextc))
                    return true;
            }
            board[row][col] = '.'; // restore
        }
        
        return false;
    }
    
    private boolean isValidSetup(char[][] board, int row, int col) {

        // check rows
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < DIM; i++) {
            if (board[i][col] == '.')
                continue;
            if (set.contains(board[i][col]))
                return false;
            set.add(board[i][col]);
        }
        
        // check columns
        set = new HashSet<Character>();
        for (int j = 0; j < DIM; j++) {
            if (board[row][j] == '.')
                continue;
            if (set.contains(board[row][j]))
                return false;
            set.add(board[row][j]);
        }

        // check individual square
        set = new HashSet<Character>();
        int sdim = (int) Math.sqrt(DIM);
        int istart = (row/sdim) * sdim;
        int jstart = (col/sdim) * sdim;
        for (int i = istart; i < istart+sdim; i++) {
            for (int j = jstart; j < jstart+sdim; j++) {
                if (board[i][j] == '.')
                    continue;
                if (set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
        }
        
        return true;
    }
}