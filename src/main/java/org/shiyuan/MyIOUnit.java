package org.shiyuan;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyIOUnit {

	List<String> tokens = new ArrayList<String>();

	public void read(InputStream input) throws IOException {
		StringBuilder builder = new StringBuilder();

		int data = input.read();
		while (data != -1) {
			if (((char) data) != ',') {
				builder.append((char) data);
			} else {
				tokens.add(builder.toString().trim());
				builder.delete(0, builder.length());
			}

			data = input.read();
		}
		tokens.add(builder.toString().trim());
	}

	public void write(OutputStream output) throws IOException {
		for (int i = 0; i < tokens.size(); i++) {
			if (i > 0) {
				output.write(',');
			}
			output.write(tokens.get(i).getBytes());
		}
	}
}