package Code_Jam_2008_Round_1A;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import common.Input;

public class Minimum_Scalar_Product {

	public static void main(String[] args) throws FileNotFoundException {

		Input input = new Input("minimum_scalar_product_small");

		ArrayList<String> results = new ArrayList<String>();

		int index = 0;

		ArrayList<String> lines = input.getTestcases();

		for (int i = 0; i < lines.size(); i += 3) {

			ArrayList<Integer> v1 = insertIntoPriorityQueue(lines.get(i+1));
			ArrayList<Integer> v2 = insertIntoPriorityQueue(lines.get(i + 2));
			
			int sum = 0;

			int v1FrontIndex = 0;
			int v1EndIndex = v1.size() - 1;

			int v2FrontIndex = 0;
			int v2EndIndex = v2.size() - 1;

			for (int j = 0; j < v1.size(); j++) {

				if (v1FrontIndex >= 0 && v2FrontIndex >= 0) {
					
					if (v1.get(v1FrontIndex).compareTo(v2.get(v2FrontIndex)) < 0) {

						sum += v1.get(v1FrontIndex) * v2.get(v2EndIndex);
												
						v1FrontIndex++;
						v2EndIndex--;
					} else {
						sum += v2.get(v2FrontIndex) * v1.get(v1EndIndex);
						v2FrontIndex++;
						v1EndIndex--;
					}
				}

			}

			results.add(sum + "");

		}

		input.write(results);

	}

	private static ArrayList<Integer> insertIntoPriorityQueue(String line) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		String[] values = line.split(" ");

		for (String value : values) {

			list.add(Integer.valueOf(value));
		}

		Collections.sort(list);

		return list;
	}

}
