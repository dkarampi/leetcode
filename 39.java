public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Arrays.sort(candidates);

		return getComboSum(candidates, target, 0, new ArrayList<Integer>(), result);
	}

	private List<List<Integer>> getComboSum(int [] candidates, int target, int idx,
			ArrayList<Integer> row, List<List<Integer>> result) {

		if (target < 0)
			return result;

		if (target == 0) {
			result.add(new ArrayList<Integer>(row));
			return result;
		}

		for (int i = idx; i < candidates.length; i++) {
			row.add(candidates[i]);
			result = getComboSum(candidates, target - candidates[i], i, row, result);
			row.remove(row.size()-1);
		}

		return result;
	}
}
