package com.digital14.codingtask.operators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.digital14.codingtask.writers.Writer;

public class DuplicateRemover extends WriterDecorator {

	public DuplicateRemover(Writer writer) {
		super(writer);
	}

	@Override
	public <S extends CharSequence> int write(S seq) {
		return super.write(removeDuplicates(seq));
	}

	private static <S extends CharSequence> String removeDuplicates(S seq) {
		String result = seq.toString();
		String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(result);
		while(match.find()) {
			result = result.replace(match.group(), match.group(1));
		}
		return result;
	}

}
