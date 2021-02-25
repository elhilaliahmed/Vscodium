/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountDogs
{

	public static int countDogs(String input)
	{
		int count = 0;
		Pattern p = Pattern.compile("d[aeuio]g");
		Matcher m = p.matcher(input);
		while (m.find()) {
			count++;
		}
		return count;
	}
}
