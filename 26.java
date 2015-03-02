public class Solution {
	public int removeDuplicates(int[] A) {

		if (A.length == 0)
			return A.length;

		int write = 0;

		for (int read = 1; read < A.length; read++) {
			if (A[read] != A[read-1])
				++write;
			A[write] = A[read];
		}

		return write + 1;
	}
}
