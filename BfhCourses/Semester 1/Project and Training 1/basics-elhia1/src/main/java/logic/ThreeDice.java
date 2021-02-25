/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package logic;

public class ThreeDice
{

	public static int getNbrOfCombinations(int sum)
	{
		int numberOfCombinations = 0;

		for (int red = 1; red <= 6; red++)
		{
			for (int green = 1; green <= 6; green++)
			{
				for (int blue = 1; blue <= 6; blue++)
				{
					if (sum == red + green + blue)
					{
						numberOfCombinations++;
					}
				}
			}
		}
		return numberOfCombinations;
	}
}
