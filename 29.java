/*
 * Not algorithmically hard. The trick is to increase/decrease the divisor
 * every time we subtract it from the dividend.
 * The problem is that we need to watch out for corner cases such ass
 * MIN_VALUE and MAX_VALUE at the input. The fact that these two numbers
 * are not symmetric around zero requires careful handling.
 */
public class Solution {
	public int divide(int dividend, int divisor) {

		if (divisor == 0)
			return Integer.MAX_VALUE;

		boolean negative = false; /* The sign of the result */
		/* 
		 * Note we should not extend the sign on the left,
		 * thus we use logical shift
		 */
		if (((dividend >>> 31) ^ (divisor >>> 31)) == 1)
			negative = true;

		/*
		 * We want to get rid of the signs but we need to be able to
		 * handle cases in which MIN_VALUE appears in the input.
		 * Thus, we cast the numbers to long
		 */
		long _dividend = dividend;
		long _divisor = divisor;
		_dividend = Math.abs(_dividend);
		_divisor = Math.abs(_divisor);

		long quotient = 0; // result
		long base = _divisor;
		long ratio = 1; // the base/divisor ratio

		/*
		 * The idea is to subtract the divisor from the dividend until the
		 * latter becomes less than or equal to zero. To speed up the process,
		 * every time we double or halve the number we subtract.
		 */
		while (_dividend > 0) {

			if (_dividend >= base) {
				_dividend -= base;
				quotient += ratio;
				base <<= 1;
				ratio <<= 1;
			}
			else {
				base >>= 1;
				ratio >>= 1;
				if (base < _divisor)
					break;
			}
		}

		if (negative)
			quotient = -quotient;

		/*
		 * Do the following to handle a tricky input like this: MIN_VALUE, -1.
		 * The expected output is MAX_VALUE.
		 */
		return (int) Math.min(Math.max(Integer.MIN_VALUE, quotient), Integer.MAX_VALUE);
	}
}
