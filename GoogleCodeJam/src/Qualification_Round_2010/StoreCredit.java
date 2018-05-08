package Qualification_Round_Africa_2010;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StoreCredit {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader reader = new BufferedReader(new FileReader(
				"D:/GoogleCodeJam/A-large-practice.in"));
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				"D:/GoogleCodeJam/A-large-practice.txt"));

		int noOfTestCases = Integer.parseInt(reader.readLine());

		System.out.println(noOfTestCases);

		for (int i = 0; i < noOfTestCases; i++) {
			Store store = readTestCase(reader);

			System.out.println(store);

			process(store, writer,i);
			
		}
		
		reader.close();
		writer.close();

	}

	private static void process(Store store,BufferedWriter writer, int caseNumber) throws IOException 
	{
		//Arrays.sort(store.getCostOfItems());

		int arrayIndex1 = 0, arrayIndex2 = 0;

		for (int j = store.getNoOfItems()-1; j >= 0; j--) {
			if (store.getCostOfItems()[j] > store.getCredit())
				continue;

			for (int i = j - 1; i >= 0; i--) {
				if (store.getCostOfItems()[j] + store.getCostOfItems()[i] == store
						.getCredit()) {
					arrayIndex1 = i;
					arrayIndex2 = j;
					break;
				}
			}
		}
		
		//Case #1: 2 3
		
		System.out.println("ArrayIndex1-" + arrayIndex1 + " Value ="
				+ store.getCostOfItems()[arrayIndex1] + " ArrayIndex2-"
				+ arrayIndex2 + " Value ="
				+ store.getCostOfItems()[arrayIndex2]);
		
		writer.write("Case #"+(caseNumber+1)+": "+(arrayIndex1+1)+" "+(arrayIndex2+1)+"\n");

	}

	private static Store readTestCase(BufferedReader reader)
			throws NumberFormatException, IOException 
	{
		Store st = new Store();

		st.setCredit(Integer.parseInt(reader.readLine()));

		st.setNoOfItems(Integer.parseInt(reader.readLine()));

		String[] prices = reader.readLine().split(" ");

		int[] actualPrices = new int[st.getNoOfItems()];

		for (int i = 0; i < st.getNoOfItems(); i++) {
			actualPrices[i] = Integer.parseInt(prices[i]);
		}

		st.setCostOfItems(actualPrices);

		return st;
	}

}
