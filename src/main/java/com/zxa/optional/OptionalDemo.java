package com.zxa.optional;

import java.util.Optional;

/**
 * @ClassName: OptionalDemo
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/26 14:39
 */
public class OptionalDemo {

	public static void main(String[] args) {
		String s = null;
		print(s);

		System.out.println(getLength(s));
		s = "test";
		print(s);
		System.out.println(getLength(s));
	}

	private static void print(Object o){
		Optional.ofNullable(o).ifPresent(System.out::println);
	}

	private static int getLength(String text){
		return Optional.ofNullable(text).map(String::length).orElse(-1);
	}


}
