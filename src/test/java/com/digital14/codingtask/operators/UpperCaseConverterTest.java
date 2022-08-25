package com.digital14.codingtask.operators;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.digital14.codingtask.writers.Writer;

class UpperCaseConverterTest {

	private static final String TEST_STRING = "aaaaaaaaaa";
	private static final String EXPECTED_STRING = "AAAAAAAAAA";
	
	@Mock
	Writer writer;
	
	private UpperCaseConverter upperCaseConverter;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		upperCaseConverter = new UpperCaseConverter(writer);
	}

	@Test
	void testWrite() {
		upperCaseConverter.write(TEST_STRING);
		verify(writer).write(EXPECTED_STRING);
	}
	
	@Test
	void testClose() {
		upperCaseConverter.close();
		verify(writer).close();
	}

}
