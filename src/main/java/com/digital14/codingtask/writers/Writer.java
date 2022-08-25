package com.digital14.codingtask.writers;

public interface Writer {
	<S extends CharSequence> int write(S seq);
	void close();
}
