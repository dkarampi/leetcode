// Clarification: "Find the first missing pointer... " --> start counting from 1.
// Two-pass algorithm. First, make sure that i+1 is assigned to A[i] (if i+ 1
// exists in the array. Then, iterate over the array and find what's missing.
// The algorithm bellow has linear complexity since we visit every position
// at most two times on average.
public class Solution {
    public int firstMissingPositive(int[] A) {
        
        for (int i = 0; i < A.length; i++) {

            // Note the last condition. We don't check for A[i] != i+1 cause
            // cases like this [1, 1] would fall into infinite loop
            while (A[i] > 0 && A[i] <= A.length && A[A[i]-1] != A[i]) {
                // we send the content of A[i] to A[A[i]-1]
                swap(A, i, A[i]-1);
                // Re-swap if needed with another element at next iteration
            }
        }
        
        for (int i = 0; i < A.length; i++)
            if (A[i] != i+1)
                return i+1;
        return A.length+1;
    }
    
    private void swap(int [] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}