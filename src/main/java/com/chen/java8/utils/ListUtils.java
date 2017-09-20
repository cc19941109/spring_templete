package com.chen.java8.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListUtils {

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {

		List<T> result = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				result.add(s);
			}
		}
		return result;

	}

	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T t : list) {
			c.accept(t);
		}

	}

	public static <T, R> List<R> get(List<T> list, Function<T, R> f) {

		List<R> result = new ArrayList<>();
		for (T s : list) {
			result.add(f.apply(s));
		}
		return result;
	}

	
}
