// Same approach as in #46 Permutations where there are no duplicates
// in the input. Here I just do an extra check inside the second loop.
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        
        Arrays.sort(num);
        List<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++)
            numList.add(num[i]);
        
        return getPermutation(numList, new ArrayList<Integer>(),
                new ArrayList<List<Integer>>());
    }
    
    private List<List<Integer>> getPermutation(List<Integer> num,
            ArrayList<Integer> row, List<List<Integer>> result) {
        
        if (num.size() == 0) {
            result.add(row);
            return result;
        }
        
        for (int i = 0; i < num.size(); i++) {
            
            if (i > 0 && num.get(i) == num.get(i-1))
                continue;
            
            ArrayList<Integer> r = new ArrayList<Integer>(row);
            int tmp = num.remove(i);
            r.add(tmp);
            result = getPermutation(num, r, result);
            num.add(i, tmp);
        }
        
        return result;
    }
}