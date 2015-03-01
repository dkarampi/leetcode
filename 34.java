// Use two binary searches to find the starting and the ending position
// of the target value. The binary searches have to be adapted so that
// they look towards left or right when A[mid] == target
// Easy to make off-by-one mistakes...
// Same approach:
// https://oj.leetcode.com/discuss/18242/clean-iterative-solution-binary-searches-with-explanation

public class Solution {
    public int[] searchRange(int[] A, int target) {
        
        int mid = 0;
        int low = 0;
        int high = A.length-1;
        int [] result = new int[2];
        result[0] = result[1] = -1;
        
        while (low < high) {
            
            mid = low + (high - low) / 2;
            
            if (target == A[mid])
                high = mid;
            else if (target < A[mid])
                high = mid - 1;
            else // target > A[mid]
                low = mid + 1;
        }
        
        // If starting position is not found... return [-1, -1]
        if (target == A[low])
            result[0] = low;
        else
            return result;
            
        // Reset the boundaries
        low = 0;
        high = A.length-1;
        while (low < high) {
            
            // Use .ceil() to round up mid
            mid = (int) Math.ceil((double)low +
                    ((double)high - (double)low) / (double)2);
            
            if (target == A[mid])
                low = mid;
            else if (target < A[mid])
                high = mid - 1;
            else // target > A[mid]
                low = mid + 1;
        }
        
        // high includes the value we look up;
        // see the following example: [1, 3], 1
        result[1] = high;
        
        return result;
    }
}