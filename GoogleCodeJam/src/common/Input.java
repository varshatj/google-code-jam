package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Input 
{
	int countOfTestCases;

	ArrayList<String> testcases;
	
	String fileName;
	
	File baseFolder = new File("C:/GoogleCodeJam");

	public Input(String fileName)
	{
		testcases = new ArrayList<String>();
		this.fileName = fileName;
		readTestCases();
	}
	/**
	 * @return the countOfTestCases
	 */
	public int getCountOfTestCases() {
		return countOfTestCases;
	}

	/**
	 * @param countOfTestCases
	 *            the countOfTestCases to set
	 */
	public void setCountOfTestCases(int countOfTestCases) {
		this.countOfTestCases = countOfTestCases;
	}

	/**
	 * @return the testcases
	 */
	public ArrayList<String> getTestcases() {
		return testcases;
	}

	/**
	 * @param testcases
	 *            the testcases to set
	 */
	public void setTestcases(ArrayList<String> testcases) {
		this.testcases = testcases;
	}

	public void setTestcase(String testcase) {
		this.testcases.add(testcase);
	}
	
	public void readTestCases()
	{
		BufferedReader reader = null;
		
		try 
		{
			File f = new File(baseFolder, fileName+".in");
			
			reader = new BufferedReader(new FileReader(f));
			
			countOfTestCases = Integer.parseInt(reader.readLine());
			
			String k ="";
			
			while( (k = reader.readLine())!=null) 
			{
				testcases.add( k);
			}
		} 
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public void write(ArrayList<String> results) throws FileNotFoundException
	{
		PrintWriter writer = null;
		
		try
		{
			File f = new File(baseFolder, fileName+".out");
			
			writer = new PrintWriter(f);
					
			for(int i = 0; i < results.size(); i++)
			{
				writer.printf("Case #%s: %s", i+1, results.get(i));
				
				writer.println();
			}
		}
		finally
		{
			writer.close();
		}
	}

}
