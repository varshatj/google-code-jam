package Qualification_Round_2017;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import common.Input;

public class Oversized_Pancake_Flipper {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Input in = new Input("A-small-practice_pancake");
		
		ArrayList<String> results = new ArrayList<String>();
		
		for(String s: in.getTestcases())
		{
			String[] stringArray = s.split(" ");
			
			int number = calculateNumberOfFlips(stringArray[0], Integer.parseInt(stringArray[1]));
			
			if(number >= 0)
			{
				results.add(String.valueOf(number));
			}
			else
			{
				results.add("IMPOSSIBLE");
			}
		}
		
		in.write(results);
	}

	private static int calculateNumberOfFlips(String pattern, int number) 
	{
		int count = 0;
		
		while ( pattern.indexOf("-") > -1)
		{
			int index = pattern.indexOf("-");
			
			if( !((index + number) <= pattern.length()))
			{
				break;
			}
			
			count++;
			pattern = flip(pattern, index, number, pattern.substring(index, index + number));
			
			
		}
		
		if(pattern.indexOf("-")>-1) return -1;
		else return count;
	}

	private static String flip(String pattern, int i, int number, String sub) 
	{
		String previous = pattern.substring(0,i);
		sub = flip(sub);
		String rest = pattern.substring(i+number, pattern.length());
		
		return previous + sub + rest;
	}

	private static String flip(String sub) 
	{
		String result = "";
		for(int i=0; i < sub.length(); i++)
		{
			if(sub.charAt(i) == '+') result = result + "-";
			else result = result + "+";
		}
		
		return result;
	}
}
