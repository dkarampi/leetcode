// Very similar to problem 39 (Combination Sum).
// I assume there is a better approach with better running time.
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);

        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

        return getComboSum(candidates, target, 0, new ArrayList<Integer>(), result, set);
    }
    
    private List<List<Integer>> getComboSum(int [] candidates, int target, int idx,
            ArrayList<Integer> row, List<List<Integer>> result, Set<ArrayList<Integer>> set) {
        
        if (target < 0)
            return result;
            
        if (target == 0) {
            Collections.sort(row);
            if (set.contains(row))
                return result;
            // make a copy
            ArrayList<Integer> r = new ArrayList<Integer>(row);
            set.add(r);
            result.add(r);
            return result;
        }
        
        for (int i = idx; i < candidates.length; i++) {
            row.add(candidates[i]);
            result = getComboSum(candidates, target - candidates[i], i+1, row, result, set);
            row.remove(row.size()-1);
        }
        
        return result;
    }
}