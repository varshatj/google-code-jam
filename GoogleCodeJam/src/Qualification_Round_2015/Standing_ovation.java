package Qualification_Round_2015;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import common.Input;

public class Standing_ovation {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Input in = new Input("C-small-attempt0");
		
		ArrayList<String> results = new ArrayList<String>();
		
		for(String s: in.getTestcases())
		{
			results.add(calculateNumberRequired(s.split(" ")[1]));
		}
		
		in.write(results);
	}

	private static String calculateNumberRequired(String s) 
	{
		int numberofPeopleRequired = 0;
		int numberOfPeopleStanding = 0;
		
		if(s.length() > 0)
		{
			numberOfPeopleStanding = Integer.parseInt(s.substring(0,1)); 
		}
		
	     for(int i =1;i < s.length() ;i++)
	     {
	    	int noOfPeoplewithShynessLevel = Integer.parseInt(s.substring(i,i+1)); 
	    	
	    	if(noOfPeoplewithShynessLevel == 0)
		    	continue;

	    	int shynessLevel = i;
	    	
	    	if(shynessLevel <= numberOfPeopleStanding)
	    	{
	    		numberOfPeopleStanding += noOfPeoplewithShynessLevel;
	    	}
	    	else
	    	{
	    		int numberRequiredCurrently = shynessLevel - numberOfPeopleStanding;
	    		
	    		numberOfPeopleStanding+=numberRequiredCurrently+noOfPeoplewithShynessLevel;
	    		numberofPeopleRequired+=numberRequiredCurrently;
	    	}
	     }
	     
	     return String.valueOf(numberofPeopleRequired);
	}
}
