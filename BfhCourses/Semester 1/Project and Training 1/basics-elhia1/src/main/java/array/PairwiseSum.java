/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package array;

public class PairwiseSum {

	public static int[] pairwiseSum(int[] values) {
		if (values.length == 0 || values.length == 1)
		{
			return new int[0];
		}

		int[] sum = new int [values.length -1];

		for (int i = 0; i < sum.length; i++)
		{
			sum[i] = values[i] + values[i +1];
		}

		return sum;
	}
}
