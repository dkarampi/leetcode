/*
 * Note the description: "each input would have exactly one solution".
 * This means that a number can appear one or two times at most in the array.
 * If a number appears twice, we are overriding the small index when inserting
 * the same key to the hashtable, nevertheless, this is not a problem.
 * We only need an additional test. 
 */
public class Solution {
	public int[] twoSum(int[] numbers, int target) {

		int [] result = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++)
			hm.put(numbers[i], i);

		for (int i = 0; i < numbers.length; i++) {
			int diff = target - numbers[i];
			if (hm.containsKey(diff)) {

				int idx2 = hm.get(diff);
				if (idx2 == i)
					continue;

				/* Found */
				result[0] = i+1;
				result[1] = idx2 + 1;
				return result;
			}
		}

		return result;
	}
}
