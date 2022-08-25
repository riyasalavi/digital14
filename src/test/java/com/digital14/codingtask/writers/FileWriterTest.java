package com.digital14.codingtask.writers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileWriterTest {
	private static String INPUT_STRING = "XXX";
	private static String EXPECTED_STRING_WRITE = "XXXXXX";
	private static String EXPECTED_STRING_CLOSE = "XXX";
	private static int EXPECTED_CHARS_WRITE = 6;
	private static int EXPECTED_CHARS_CLOSE = 3;

	private Path path;
	private File file;
	private String fileName;

	@TempDir
	Path tempDir;

	@BeforeEach
	void setUp() throws Exception {
		path = tempDir.resolve("testfile.txt");
		file = path.toFile();
		fileName = file.getAbsolutePath();
	}

	@Test
	void testStringConstructor() throws Exception {
		FileWriter writer = new FileWriter(fileName);
		writer.close();
		assertTrue(file.exists());
	}

	@Test
	void testFileConstructor() throws Exception {
		FileWriter writer = new FileWriter(file);
		writer.close();
		assertTrue(file.exists());
	}

	@Test
	void testWritingToString() throws Exception {
		FileWriter writer = new FileWriter(file);
		int characterWritten = 0;
		characterWritten += writer.write(INPUT_STRING);
		characterWritten += writer.write(INPUT_STRING);
		writer.close();
		FileReader reader = new FileReader(file);
		int i;
		StringBuilder sb = new StringBuilder();
		try {
			while ((i = reader.read()) != -1)
				sb.append((char)i);
		} finally {
			reader.close();
		}
		assertEquals(EXPECTED_STRING_WRITE, sb.toString());
		assertEquals(EXPECTED_CHARS_WRITE, characterWritten);
	}

	@Test
	void testWritingToClosedStream() throws IOException {
		FileWriter writer = new FileWriter(file);
		int characterWritten = 0;
		characterWritten += writer.write(INPUT_STRING);
		writer.close();
		characterWritten += writer.write(INPUT_STRING);
		FileReader reader = new FileReader(file);
		int i;
		StringBuilder sb = new StringBuilder();
		try {
			while ((i = reader.read()) != -1)
				sb.append((char)i);
		} finally {
			reader.close();
		}

		assertEquals(EXPECTED_STRING_CLOSE, sb.toString());
		assertEquals(EXPECTED_CHARS_CLOSE, characterWritten);
	}

}
