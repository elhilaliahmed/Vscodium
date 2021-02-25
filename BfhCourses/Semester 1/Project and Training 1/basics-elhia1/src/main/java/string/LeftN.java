/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package string;

public class LeftN {

	public static String leftN(String str, int n)
	{
		if (str.length() >= n)
		{
			return str.substring(n) + str.substring(0, n);
		}
		return str;
	}
}
