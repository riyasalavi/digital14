package com.digital14.codingtask.operators;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.digital14.codingtask.writers.Writer;

class LowerCaseConverterTest {
	
	private static final String TEST_STRING = "AAAAAAAAAA";
	private static final String EXPECTED_STRING = "aaaaaaaaaa";
	
	@Mock
	Writer writer;
	
	private LowerCaseConverter lowerCaseConverter;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		lowerCaseConverter = new LowerCaseConverter(writer);
	}

	@Test
	void testWrite() {
		lowerCaseConverter.write(TEST_STRING);
		verify(writer).write(EXPECTED_STRING);
	}
	
	@Test
	void testClose() {
		lowerCaseConverter.close();
		verify(writer).close();
	}

}
