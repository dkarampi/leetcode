public class Solution {
	public int removeElement(int[] A, int elem) {

		int read, write;

		for (write = 0, read = 0; read < A.length; read++) {
			A[write] = A[read];
			if (A[write] != elem)
				++write;
		}

		return write;
	}
}
