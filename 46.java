public class Solution {
	public List<List<Integer>> permute(int[] num) {

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
			ArrayList<Integer> r = new ArrayList<Integer>(row);
			int tmp = num.remove(i);
			r.add(tmp);
			result = getPermutation(num, r, result);
			num.add(i, tmp);
		}

		return result;
	}
}
