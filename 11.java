/*
 * See also the 2sum problem.
 * We begin with two pointers, one at start, one at
 * the end of the array and move them towards each other.
 * Every time we update the maximum capacity.
 */
public class Solution {
	public int maxArea(int[] height) {

		int maxCap = 0;

		for (int left = 0, right = height.length-1; left < right;) {

			int capacity = Math.min(height[left], height[right]) * (right - left);
			maxCap = Math.max(maxCap, capacity);

			/* Move the index that points the to the shortest height */
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return maxCap;
	}
}
