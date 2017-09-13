package com.chen.IOTest;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileTest {

	public static void main(String[] args) {
		String path = "/Users/chencheng/git/learn/Doc";
		File file = new File(path);
		System.out.println(file.exists());
		String[] liStrings;

		liStrings = file.list(new DirFilter("[a-zA-Z0-9_]*.md"));
//		liStrings = file.list();

		Arrays.sort(liStrings, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : liStrings) {
			System.out.println(dirItem);
		}
	}

}

class DirFilter implements FilenameFilter {
	private Pattern pattern;
	public DirFilter(String regex) {
		pattern = Pattern.compile(regex);
	}

	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();

	}

}