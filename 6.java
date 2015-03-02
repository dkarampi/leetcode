/*
 * I write the String into a char [][] in a zig-zag way and then I read line by line.
 * It was tricky to calculate the number of columns and to make sure the row & col
 * variables are allways at the right position.
 */
public class Solution {
	public String convert(String s, int nRows) {

		/* Deal with a stupid input like this: "A", 2 */
		if (s.length() <= nRows || nRows == 1)
			return s;

		/* For every nRows - 2 columns, I can fit 2 * nRows - 2 elements */
		int submatrix = (int) Math.ceil((double)s.length() / (2 * nRows - 2));
		/* Here I find out how many */
		int nCols = submatrix * (nRows - 1);

		char [][] array = new char[nRows][nCols];

		boolean goDown = true;

		int row = 0;
		int col = 0;
		for (int i = 0; i < s.length();) {

			if (goDown) {
				for (; i < s.length() && row < nRows; i++, row++)
					array[row][col] = s.charAt(i);

				goDown = false;
				/* row is out of bounds, make it point to the nRows-1 row */
				row -= 2;
				++col;
			}
			else { /* Move diagonally towards upper right part */

				for (; i < s.length() && row > 0; i++, row--, col++)
					array[row][col] = s.charAt(i);

				/* We are at [0][col] element */
				goDown = true;
			}
		}

		int k = 0;
		char [] result = new char[s.length()];
		/* Read the string line by line */
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (array[i][j] == '\u0000') /* null character */
					continue;
				result[k++] = array[i][j];
			}
		}

		return new String(result);
	}
}


/*
 * The following is more space efficient (turns to be faster too)
 */
public class Solution {
	public static String convert(String text, int nRows) {

		if (nRows >= text.length() || nRows == 1)
			return text;

		/*
		 * PAYPALISHIRING --> PAHNAPLSIIGYIR
		 * P   A   H   N
		 * A P L S I I G
		 * Y   I   R
		 */

		StringBuilder result = new StringBuilder(text);

		int j = 0;
		int padding = nRows + nRows - 2;

		for (int i = 0; i < nRows; i++) {

			for (int k = i; k < text.length(); ) {

				result.setCharAt(j++, text.charAt(k));

				if (i != 0 && i != nRows -1 && k+padding-2*i < text.length()) {    				
					result.setCharAt(j++, text.charAt(k+padding-2*i));
				}
				k += padding;
			}
		}

		return result.toString();
	}
}
