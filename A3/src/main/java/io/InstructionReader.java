package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InstructionReader implements Reader {

	// read instructions from text files
	public List<String> read(String fileName) {
		List<String> lines = new ArrayList<>();

		try {
			String currentDIR = new java.io.File(".").getCanonicalPath();
			System.out.println("Current directory:" + currentDIR);
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
				if (line.length() > 0) {
					lines.add(line);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Error working with filesystem: " + e.getMessage());
		}
		return lines;
	}
}
