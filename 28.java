public class Solution {
	public int strStr(String haystack, String needle) {

		/* For input "", "" I need to return 0... which is wrong IMO */
		if (needle.equals(""))
			return 0;

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {

			int j = 0;
			while (j < needle.length() && haystack.charAt(i+j) == needle.charAt(j))
				++j;
			if (j == needle.length())
				return i;
		}
		return -1;
	}
}
