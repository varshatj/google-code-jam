package Qualification_Round_2008;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import common.Input;

public class Saving_the_Universe {

	public static void main(String[] args) throws FileNotFoundException 
	{		
		Input in = new Input("Saving_the_universe-small");
		
		ArrayList<String> results = new ArrayList<String>();
		
		int numberOfTests = in.getCountOfTestCases();
		
		int index = 0;
		
		ArrayList<String> lines = in.getTestcases();
		
		for(int i = 0; i < numberOfTests; i++)
		{
			HashMap<String, Integer> searchEngine = new HashMap<String, Integer>();
			
			int numberOfSearchEngines = Integer.parseInt(lines.get(index));
			
			for(int j=1;j<=numberOfSearchEngines;j++)
			{
				index++;
				searchEngine.put(lines.get(index),0);
			}
			
			index++;
		
			int searches = Integer.parseInt(lines.get(index));
			
			for(int k=1;k<=searches;k++)
			{
				index++;
				int number = searchEngine.get(lines.get(index));
				searchEngine.put(lines.get(index), number+1);
			}
						
			index++;
			
			int small = Integer.MAX_VALUE;
			
			for(String jh: searchEngine.keySet())
			{
				small = (small < searchEngine.get(jh))?small:searchEngine.get(jh);
			}
			
			results.add(String.valueOf(small));
		}
		
		in.write(results);
	}
}
