package Qualification_Round_Africa_2010;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;

import common.Input;

public class T9Spelling 
{
	HashMap<String, String> alpha;
	
	HashMap<String, String> alphaGroup;

	public T9Spelling() 
	{
		alpha = new HashMap<String, String>();
		
		alphaGroup = new HashMap<String, String>();

		alpha.put(" ", "0");
		
		alphaGroup.put(" ", "0");

		String digit = "2";

		int counter = 0;
		
		int changeCount = 3;

		String localDigit = digit;
		
		for (char i = 'a'; i <= 'z'; i++) 
		{
			if(counter == changeCount)
			{
				digit = String.valueOf(Integer.parseInt(digit) + 1);
				localDigit = digit;
				counter =0;
				changeCount=3;
			}
			
			if ((Character.compare(i, 'p') == 0)
					|| (Character.compare(i, 'w') == 0)) 
			{
				changeCount = 4;
			}

			counter++;
			
			alpha.put(String.valueOf(i), localDigit);
			alphaGroup.put(String.valueOf(i), digit);

			localDigit += digit;
		}
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		PrintWriter pw = new PrintWriter("D:/GoogleCodeJam/C-large-practice.out");
		
		Input in = new Input("D:/GoogleCodeJam/C-large-practice.in");
		
		T9Spelling rw = new T9Spelling();
		
		int count = 1;
		
		for(String s : in.getTestcases())
		{
			String number = rw.getT9Spelling(s);
			
			pw.printf("Case #%s: %s", count++, number);
			
			pw.println();
			
			System.out.println("String: "+ s+":"+number);
		}
		
		pw.close();
	}

	private String getT9Spelling(String s) 
	{
		StringBuilder build = new StringBuilder();
		
		String previous = String.valueOf(s.charAt(0));
		
		String current = String.valueOf(s.charAt(0));
		
		build.append(alpha.get(current));
		
		for(int i = 1; i < s.length() ; i++)
		{
			current = String.valueOf(s.charAt(i));
			
			if(alphaGroup.get(current).equals(alphaGroup.get(previous)))
			{
				build.append(" ");
			}
			
			build.append(alpha.get(current));
			
			previous = current;
		}
		
		return build.toString();
	}
}
