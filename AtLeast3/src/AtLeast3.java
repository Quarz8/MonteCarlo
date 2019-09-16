public class AtLeast3
{

	public static void main(String[] args)
	{
		// Form table format, N people in room | Chance for 3 to share a birthday
		System.out.printf("%-20s%-5s%-10s%n", "Number of People", "|", "Chance 3 Share a Birthday");
		// For N=10 through N=100
		for (int N = 10; N <= 100; N++)
		{
			int sharedBDays = 0; // stores number of times at least 3 people out of N share a birthday
			
			for (int monteCarlo = 0; monteCarlo < 500000; monteCarlo++) // Repeat experiment 500,000 times...
			{
				int[] birthdays = new int[N]; // create array to store birthday values
				// Generate N random integers between [0, 364) representing
				// each day of a year (i.e. birthdays). Note: 365 days in a year
				for (int i = 0; i < N; i++)
				{
					// Assign random int 0 through 364 to the array; [0, 365) i.e. 365 possible ints
					birthdays[i] = (int) (365 * Math.random());
				}
				// Check if there are at least 3 occurrences of a birthday (0-364)
				for (int i = 0; i < 365; i++)
				{ // for each day, i, of a year...
					int occurrences = 0; // used to track number of occurrences of day i in array
					for (int j = 0; j < N; j++)
					{ // for each value in the array...
						if (birthdays[j] == i) // if day in array is equal to the searched day i...
							occurrences++; // increment the number of occurrences by 1
					}
					if (occurrences >= 3)
					{ // if so, at least 3 people share a birthday
						sharedBDays++;// increment sharedBDays by 1
						break; // break out of (for(int i=0; i<365; i++) loop as the question is answered
					}
				}
			}
			// Print the data to the table for monteCarlo of N
			System.out.printf("%-20s%-5s%s%s%n", N, "|", ((double) sharedBDays / 500000) * 100, "%");
		}
	}
}
