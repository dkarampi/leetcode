/*
 * Use a modified version of binary search.
 * Find the middle and partition the array into left and right.
 * Either of them will be sorted and the other will include the
 * start of the rotation (cut). There are 4 (+1 where target == A[mid])
 * cases every time. Examine them all.
 * An alternative approach is to look up first for the cut, by comparing
 * A[mid] with A[mid+1] every time. Then we choose one of the two
 * partitions and do binary search.
 */
public class Solution {
	public int search(int[] A, int target) {

		int low = 0;
		int high = A.length-1;

		while (low <= high) {

			/* Avoid overflow, same as mid = (low + high) / 2 */
			int mid = low + ((high - low) / 2);

			if (target == A[mid])
				return mid;

			/*
			 * I had to use <= here, even though target != A[mid].
			 * There was an annoying off-by-one error happening when
			 * both left and right side are sorted, but the whole array
			 * is not (the cut is between A[mid] and A[mid+1]), i.e. A = [3, 1]
			 */
			if (A[low] <= A[mid]) {
				/* Left side is sorted, cut is on the right */
				if (target < A[mid] && target >= A[low])
					high = mid - 1;
				else
					low = mid + 1;
			}
			else { /* Right side is sorted, cut is on the left */
				if (target > A[mid] && target <= A[high])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}

		return -1;
	}
}
