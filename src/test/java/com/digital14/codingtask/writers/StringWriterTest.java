package com.digital14.codingtask.writers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StringWriterTest {
	private static String INPUT_STRING = "XXX";
	private static String EXPECTED_STRING_WRITE = "XXXXXX";
	private static String EXPECTED_STRING_CLOSE = "XXX";
	private static int EXPECTED_CHARS_WRITE = 6;
	private static int EXPECTED_CHARS_CLOSE = 3;
	

	@Test
	void testWritingToString() {
		StringWriter writer = new StringWriter();
		int characterWritten = 0;
		characterWritten+=writer.write(INPUT_STRING);
		characterWritten+=writer.write(INPUT_STRING);
		writer.close();
		assertEquals(EXPECTED_STRING_WRITE, writer.read());
		assertEquals(EXPECTED_CHARS_WRITE, characterWritten);
	}

	@Test
	void testWritingToClosedStream() {
		StringWriter writer = new StringWriter();
		int characterWritten = 0;
		characterWritten+=writer.write(INPUT_STRING);
		writer.close();
		characterWritten+=writer.write(INPUT_STRING);
		assertEquals(EXPECTED_STRING_CLOSE, writer.read());	
		assertEquals(EXPECTED_CHARS_CLOSE, characterWritten);
	}
}
