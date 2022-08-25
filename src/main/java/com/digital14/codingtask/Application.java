
package com.digital14.codingtask;

import java.io.IOException;

import com.digital14.codingtask.operators.DuplicateRemover;
import com.digital14.codingtask.operators.LowerCaseConverter;
import com.digital14.codingtask.operators.StupidRemover;
import com.digital14.codingtask.operators.UpperCaseConverter;
import com.digital14.codingtask.writers.FileWriter;
import com.digital14.codingtask.writers.StringWriter;
import com.digital14.codingtask.writers.Writer;

/**
 * This demonstrate a typical usage for the solution.
 * Operators can be chained together before feeding to a writer.
 */
public class Application {
	public static void main(String[] args) {
		useStringWriter();
		useFileWriter();
	}
	
	private static void useStringWriter() {
		StringWriter writer = new StringWriter();
		Writer decoratedWriter = new DuplicateRemover(writer);
		decoratedWriter = new UpperCaseConverter(decoratedWriter);
		decoratedWriter = new StupidRemover(decoratedWriter);
		writeToWriter(decoratedWriter);
		System.out.println(writer.read());
	}
	
	private static void useFileWriter() {
		FileWriter writer = null;
		try {
			writer = new FileWriter("test.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Writer decoratedWriter = new DuplicateRemover(writer);
		decoratedWriter = new StupidRemover(decoratedWriter);
		decoratedWriter = new LowerCaseConverter(decoratedWriter);
		writeToWriter(decoratedWriter);
	}

	private static void writeToWriter(Writer writer) {
		writer.write("This is really really stupid!!!");
		writer.close();
	}
}
