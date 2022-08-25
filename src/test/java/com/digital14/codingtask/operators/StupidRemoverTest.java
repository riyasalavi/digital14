package com.digital14.codingtask.operators;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.digital14.codingtask.writers.Writer;

class StupidRemoverTest {

	private static final String TEST_STRING = "AAAA stupid BBBB";
	private static final String EXPECTED_STRING = "AAAA s***** BBBB";
	
	@Mock
	Writer writer;
	
	private StupidRemover stupidRemover;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		stupidRemover = new StupidRemover(writer);
	}

	@Test
	void testWrite() {
		stupidRemover.write(TEST_STRING);
		verify(writer).write(EXPECTED_STRING);
	}
	
	@Test
	void testClose() {
		stupidRemover.close();
		verify(writer).close();
	}

}
