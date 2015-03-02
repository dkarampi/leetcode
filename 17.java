public class Solution {
	public List<String> letterCombinations(String digits) {

		HashMap<Character, String> hm = new HashMap<Character, String>();
		hm.put('2', "abc");
		hm.put('3', "def");
		hm.put('4', "ghi");
		hm.put('5', "jkl");
		hm.put('6', "mno");
		hm.put('7', "pqrs");
		hm.put('8', "tuv");
		hm.put('9', "wxyz");

		List<String> result = new ArrayList<String>();
		result.add("");

		for (int i = 0; i < digits.length(); i++) {
			String key = hm.get(digits.charAt(i));

			List<String> cache = result;
			result = new ArrayList<String>();

			for (int j = 0; j < key.length(); j++) {
				char c = key.charAt(j);
				for (String s : cache)
					result.add(new String(s + c));
			}
		}

		return result;
	}
}
