package com.digital14.codingtask.operators;

import com.digital14.codingtask.writers.Writer;

public class UpperCaseConverter extends WriterDecorator {

	public UpperCaseConverter(Writer writer) {
		super(writer);
	}

	@Override
	public <S extends CharSequence> int write(S seq) {
		return super.write(String.valueOf(seq).toUpperCase());
	}
	
}
