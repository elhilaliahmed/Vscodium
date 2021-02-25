/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package array;

import java.util.Arrays;
import java.util.TreeSet;

public class SameNumbers {

	public static boolean sameNumbers(int[] values1, int[] values2) {
		if (Arrays.equals(values1, values2)) {return true;}

		TreeSet<Integer> values1Sorted = new TreeSet<>();

		for(int i = 0; i <values1.length; i++)
		{
			values1Sorted.add(values1[i]);
		}

		TreeSet<Integer> values2Sorted = new TreeSet<>();

		for(int i = 0 ;i <values2.length; i++)
		{
			values2Sorted.add(values2[i]);
		}

		return values1Sorted.equals(values2Sorted);
	}
}
