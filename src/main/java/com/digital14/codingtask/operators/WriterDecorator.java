package com.digital14.codingtask.operators;

import com.digital14.codingtask.writers.Writer;

abstract class WriterDecorator implements Writer {
	
	protected final Writer writer;

	public WriterDecorator(Writer writer) {
		super();
		this.writer = writer;
	}

	@Override
	public <S extends CharSequence> int write(S seq) {
		return writer.write(seq);
	}

	@Override
	public void close() {
		writer.close();	
	}
	
}
