/*
 * In general, a String in Java is composed of characters in UTF-16 format.
 * However, in this case, an array of size 128 seems to be enough to keep track
 * the position at which I last saw each character.
 * The Longest Substring Without Repeating Characters (LSWRC) including a
 * character at position position i of String s, is either the LSWRC at position i-1 plus one,
 * or the value denoted by the distance of i minus the last index we saw the character at s[i].
 * We use the minimum between these two values.
 */
public class Solution {
	public int lengthOfLongestSubstring(String s) {

		if (s.isEmpty())
			return 0;

		int [] lastSeen = new int[128];
		Arrays.fill(lastSeen, -1);
		int maxlen = 0;
		int len = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			len = Math.min(i - lastSeen[c], len + 1);
			maxlen = Math.max(maxlen, len);
			lastSeen[c] = i;
		}

		return maxlen;
	}
}
