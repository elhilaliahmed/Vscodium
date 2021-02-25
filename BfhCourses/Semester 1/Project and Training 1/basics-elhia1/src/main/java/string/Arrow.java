/*
 * Project and Training 1 - Computer Science, Berner Fachhochschule
 */

package string;

public class Arrow
{

	public static String arrow(int length, boolean doubleEnded, boolean doubleLine)
	{
		String arrow = "";

		if (length == 0)
		{

			return arrow;
		}

		String thickness = (doubleLine) ? "=" : "-";

		if (length > 0)
		{
			String arrowHead = (doubleEnded) ? ">>" : ">";

			for (int i = 0; i < length; i++)
			{
				arrow += thickness;
			}
			arrow += arrowHead;
		}
		else
		{
			String leftHead = (doubleEnded) ? "<<" : "<";
			arrow += leftHead;
			for (int i = 0; i > length; i--)
			{
				arrow += thickness;
			}
		}
		return arrow;
	}
}
