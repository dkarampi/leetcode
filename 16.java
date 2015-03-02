/*
 * Similar to 2Sum and 3Sum problems, however we cannot
 * prune search space in the same way.
 */
public class Solution {
	public int threeSumClosest(int[] num, int target) {

		Arrays.sort(num);

		/*
		 * I'm not sure to what I should initialize this.
		 * I'll use the first three elements of the array.
		 */
		int closest = num[0] + num[1] + num[2];

		for (int i = 0; i < num.length-2; i++) {

			if (i > 0 && num[i] == num[i-1]) // skip, no need to check again
				continue;

			int prev = Integer.MAX_VALUE;

			/* Use two pointers to search the rest of the array for the key */
			for (int left = i+1, right = num.length-1; left < right; ) {

				// diff is zero when the items are found
				int diff = target - num[i] - num[left] - num[right];

				/*
				 * The idea here is to abort if diverge but it doesn't work in this case.
				 * see this example: target = 107, num[i] = 1
				 * left points to 5 and right points to 100 on the list below:
				 * ... 5, 15, ..., 91, 100
				 * num[i] + num[left] + num[right] = 106; (diff = 1) and thus we increase
				 * left index. So, num[i] + num[left] + num[right] = 116; (diff = 8) now
				 * if I maintain the "optimization" below, the loop will brake and I will
				 * never examine the case:
				 * num[i] + num[left] + num[right] = 1 + 15 + 91 = 107; (diff = 0)
				 *
				 * if (Math.abs(diff) > Math.abs(prev))
				 *    break;
				 */

				if (Math.abs(diff) < Math.abs(target - closest))
					closest = num[i] + num[left] + num[right];

				if (diff > 0) {
					do { ++left; } while (left < right && num[left] == num[left-1]);
				} else if (diff < 0) {
					do { --right; } while (right > left && num[right] == num[right+1]);
				} else { /* Found */
					return target;
				}    

				prev = diff;
			}
		}

		return closest;
	}
}
