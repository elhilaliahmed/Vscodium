/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package logic;

public class LoneSum
{

	public static int loneSum(int[] values)
	{
		int sum = 0;

		for (int i = 0; i < values.length; i++)
		{
			boolean areEqual = false;
			for (int j = 0; j < values.length; j++)
			{
				if (i !=j)
				{
					if (values[i] == values[j])
					{
						areEqual = true;
					}
				}
			}
			if (!areEqual)
			{
				sum = sum + values[i];
			}
		}
		return sum;
	}

}
