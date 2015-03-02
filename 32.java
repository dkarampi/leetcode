/*
 * We use a stack to store the index of the last open parenthesis.
 * Using the current index of a ')' we can easily calculate the distance
 * to the '(' it matches with.
 * memo array is used to keep track the length of the well-formed
 * parenthesis up to the i-th position.
 */
public class Solution {
	public int longestValidParentheses(String s) {

		Stack<Integer> stack = new Stack<Integer>();
		int [] memo = new int[s.length()];

		int maxlen = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			}
			else { /* process ')' */
				if (stack.isEmpty()) {
					continue;
				}

				/* This is the index of the last open parenthesis */
				int lop = stack.pop();

				if (lop > 0)
					memo[i] = i - lop + 1 + memo[lop-1];
				else
					memo[i] = i + 1;

				maxlen = Math.max(maxlen, memo[i]);
			}
		}

		return maxlen;
	}
}
