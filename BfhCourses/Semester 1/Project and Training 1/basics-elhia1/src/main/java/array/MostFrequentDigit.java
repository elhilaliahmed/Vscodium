/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package array;

public class MostFrequentDigit
{

	public static int getMostFrequentDigit(String digitString)
	{
		int[] frequency = new int[10];

		for (int i = 0; i < digitString.length(); i++)
		{
			int digit = digitString.charAt(i) - '0';
			frequency[digit]++;
		}

		int mostFrequentDigit = 0;
		int highestFrequency = frequency[0];

		for (int i = 0; i < 10; i++)
		{
			if (frequency[i] > highestFrequency)
			{
				highestFrequency = frequency[i];
				mostFrequentDigit = i;
			}
		}
		return mostFrequentDigit;
	}
}
