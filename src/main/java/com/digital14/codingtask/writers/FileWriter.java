package com.digital14.codingtask.writers;

import java.io.File;
import java.io.IOException;

public class FileWriter implements Writer {

	private java.io.FileWriter fileWriter;

	public FileWriter(File file) throws IOException {
		super();
		file.createNewFile();
		this.fileWriter = new java.io.FileWriter(file);
	}

	public FileWriter(String fileName) throws IOException {
		this(new File(fileName));
	}

	@Override
	public <S extends CharSequence> int write(S seq) {
		if (fileWriter != null)
			try {
				fileWriter.write(seq.toString());
				fileWriter.flush();
			} catch (IOException e) {
				return 0;
			}
		else
			return 0;
		return seq.length();
	}

	@Override
	public void close() {
		try {
			fileWriter.close();
			fileWriter = null;
		} catch (IOException e) {
			throw new RuntimeException("Failed to close output stream.", e);
		}
	}

}
