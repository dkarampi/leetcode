public class Solution {
    public int searchInsert(int[] A, int target) {

        int low = 0;
        int high = A.length - 1;
        
        while (low <= high) {
            
            int mid = low + (high - low) / 2;
            
            if (target == A[mid])
                return mid;
            else if (target < A[mid])
                high = mid - 1;
            else // target > A[mid]
                low = mid + 1;
        }
        
        // This turned out to be the tricky part. I need to return low.
        // Examin the second and the third branch inside the loop. In either
        // case, low turns out to hold the correct value.
        return low;
    }
}