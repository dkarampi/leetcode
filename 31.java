// Not a hard problem. The algorithm was derived from test/example cases
// The idea is to find a number A that is less than his former, reading from
// right towards left. Once found (number 5 in the example below) it gets swapped
// with the first greater number that is on its right (6 in this case)
// All we need to do at the end, is to reverse the (ordered array) up to the new
// index of 6 now. i.e 10 7 5 3 2 becomes 2 3 5 7 10
// x x x  5 10 7 6 3 2 --> x x x 6 3 2 5 7 10

public class Solution {
    public void nextPermutation(int[] num) {
        
        if (num.length < 2)
            return;
        
        for (int i = num.length-2; i >= 0; i--) {
            if (num[i] < num[i+1]) {
                int j;
                // binary search might be faster here
                for (j = num.length-1; j > i; j--)
                    if (num[j] > num[i])
                        break;
                // Number found, swap them
                int tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
                
                reverse(num, i+1);
                return;
            }
        }
        
        reverse(num, 0);
        
        return;
    }
    
    private void reverse(int [] num, int start) {
        
        for (int i = start, j = num.length-1; i < j; i++, j--) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
    }
}