package greetings;

import java.util.Scanner;

public class Greetings
{
	public static String getGreeting(String city)
	{
		String greeting;

		if (city.equalsIgnoreCase("Bern") || city.equalsIgnoreCase("Berlin"))
		{
			greeting = "Guten Tag!";
		}
		else if (city.equalsIgnoreCase("London") || city.equalsIgnoreCase("Boston"))
		{
			greeting = "Hello!";
		}
		else if (city.equalsIgnoreCase("Milano"))
		{
			greeting = "Ciao!";
		}
		else if (city.equalsIgnoreCase("Madrid"))
		{
			greeting = "Hola!";
		}
		else if (city.equalsIgnoreCase("Paris"))
		{
			greeting = "Bonjour!";
		}
		else
		{
			greeting = "City not found!";
		}
		return greeting;
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a city: ");
		String city = scanner.nextLine();
		System.out.println(getGreeting(city));
		scanner.close();
	}
}
