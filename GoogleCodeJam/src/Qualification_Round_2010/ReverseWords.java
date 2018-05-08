package Qualification_Round_Africa_2010;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import common.Input;

public class ReverseWords {

	public static void main(String[] args) throws FileNotFoundException 
	{
		//Input in = new Input("Reverse-small-practice");
		
		Input in = new Input("Reverse-large-practice");
		
		ArrayList<String> results = new ArrayList<String>();
		
		for(String s: in.getTestcases())
		{
			results.add(reverseWords(s));
		}
		
		in.write(results);
	}

	private static String reverseWords(String s) 
	{
		String[] parts = s.trim().split(" ");
		
		StringBuilder build = new StringBuilder();
		
		for(int i = parts.length - 1; i >=0; i--)
		{
			build.append(parts[i]+" ");
		}
		
		build.setLength(build.length() - 1);
		
		return build.toString();
	}

}
