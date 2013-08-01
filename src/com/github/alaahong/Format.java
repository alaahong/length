package com.github.alaahong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.alaahong.FormatSeparator.FormatException;

public class Format {

	/**
	 * @author Zhe Zhang
	 * @param args
	 * @throws FormatException
	 * @throws NumberFormatException
	 *             please use JDK1.7+
	 */
	public static void main(String[] args) throws NumberFormatException,
			FormatException {
		try {
			// read file content from file
			List<String[]> tempList = new ArrayList<String[]>();
			List<Double> doubleList = new ArrayList<Double>();
			Map<String, Double> tempMap = new HashMap<String, Double>();
			FileReader reader = new FileReader(System.getProperty("user.dir")
					+ File.separator + "input.txt");
			BufferedReader br = new BufferedReader(reader);
			String str = null;
			int counter = 0;
			while ((str = br.readLine()) != null) {
				tempList.add(str.split(" "));
			}
			FormatSeparator fs = new FormatSeparator();
			for (String[] s : tempList) {
				if (counter < 6) {
					tempMap.put(s[1], Double.parseDouble(s[3]));
					counter++;
				} else if (counter++ > 6 && counter < 18) {
					Double tempDouble = 0d;
					for (int i = 0; i < s.length; i++) {
						if (i == 0) {
							tempDouble += Double.parseDouble(s[i])
									* tempMap.get(fs.formatSeparator(s[i + 1]));
						} else if (((i - 2) % 3) == 0) {
							if (s[i].equals("+")) {
								tempDouble += Double.parseDouble(s[i + 1])
										* tempMap.get(fs
												.formatSeparator(s[i + 2]));
							} else if (s[i].equals("-")) {
								tempDouble -= Double.parseDouble(s[i + 1])
										* tempMap.get(fs
												.formatSeparator(s[i + 2]));
							}
						}
					}
					doubleList.add(tempDouble);
				}
			}
			br.close();
			reader.close();

			// write string to file
			FileWriter writer = new FileWriter(System.getProperty("user.dir")
					+ File.separator + "output.txt");
			BufferedWriter bw = new BufferedWriter(writer);
			DecimalFormat df = new DecimalFormat("0.00");
			String crlf = System.getProperty("line.separator");
			bw.write("argentum.zhang@gmail.com");
			bw.write(crlf + "");
			for (Double d : doubleList) {
				bw.write(crlf + df.format(d) + " m");
			}
			bw.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}