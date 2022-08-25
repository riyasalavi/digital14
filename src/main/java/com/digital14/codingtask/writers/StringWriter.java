package com.digital14.codingtask.writers;

public class StringWriter implements Writer {
	
	private final StringBuffer store = new StringBuffer();
	private boolean closed = false;
	
	public String read() {
		return store.toString();
	}

	@Override
	public <S extends CharSequence> int write(final S seq) {
		int charsWritten = 0;
		if (!closed) {
			store.append(seq);
			charsWritten = seq.length();
		}
		return charsWritten;
	}

	@Override
	public void close() {
		closed = true;
	}

}
