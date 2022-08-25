package com.digital14.codingtask.operators;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.digital14.codingtask.writers.Writer;

class DuplicateRemoverTest {

	private static final String TEST_STRING = "AA BB AA AA AA aa CC";
	private static final String EXPECTED_STRING = "AA BB AA aa CC";
	
	@Mock
	Writer writer;
	
	private DuplicateRemover duplicateRemover;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		duplicateRemover = new DuplicateRemover(writer);
	}

	@Test
	void testWrite() {
		duplicateRemover.write(TEST_STRING);
		verify(writer).write(EXPECTED_STRING);
	}
	
	@Test
	void testClose() {
		duplicateRemover.close();
		verify(writer).close();
	}

}
