package Qualification_Round_2017;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import common.Input;

public class Tidy_Numbers {

	public static void main(String args[]) throws FileNotFoundException 
	{
		Input in = new Input("B-large");

		ArrayList<String> results = new ArrayList<String>();

		for (String s : in.getTestcases()) {
			
			String numberString = s;

			boolean isNumberTidy = isNumberTidy(stripLeadingZeros(s));
			
			if(isNumberTidy)
			{
				results.add(s);
			}
			else
			{
				while(!isNumberTidy)
				{
					numberString = stripLeadingZeros(getLastTidyNumber(numberString));
					
					isNumberTidy = isNumberTidy(numberString);
				}
				
				results.add(numberString);
			}			
		}

		in.write(results);
	}

	private static String stripLeadingZeros(String lastTidyNumber) 
	{
		int i=0;
		
		while(lastTidyNumber.charAt(i)=='0')
		{
			i++;
		}
		
		return lastTidyNumber.substring(i);
	}

	private static String getLastTidyNumber(String number) 
	{
		String numberString = number;
		
		for(int i= 0; i < numberString.length() - 1 ; i++)
		{
			int charAti = numberString.charAt(i);
			int charAti1 = numberString.charAt(i+1);
			
			if(charAti1 < charAti)
			{
				String previous = numberString.substring(0, i);
				int numberChar = numberString.charAt(i) - 1;
				numberString = previous + (char) numberChar + get9s(numberString.length() - (i+1));
				break;
			}
		}	
		
		return numberString;
	}

	private static String get9s(int number) 
	{
		String result = "";
		for(int i=0; i< number ; i++)
		{
			result +="9";
		}
		return result;
	}
	
	private static boolean isNumberTidy(String numberString)
	{
		for(int i= 0; i < numberString.length() - 1; i++)
		{
			int charAti = numberString.charAt(i);
			int charAti1 = numberString.charAt(i+1);
			
			if(charAti1 < charAti)
			{
				return false;
			}
		}
		
		return true;
	}
}
