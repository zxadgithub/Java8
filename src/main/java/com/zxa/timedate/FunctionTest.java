package com.zxa.timedate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @ClassName: FunctionTest
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/9/11 9:31
 */
public class FunctionTest {
	public static void main(String[] args) {
//		testMoreIfElse();

		testString();
	}

	private static void testString() {

		String test = "zxa";
		String test1 = "aaa";
		validateString(test,a -> a.isEmpty()?"空":a.toUpperCase());
		testMoreIfElse();
	}

	private static void validateString(String test, Function<String,String> function) {

		System.out.println(function.apply(test));
	}

	private static void testMoreIfElse() {
		Map<Integer,Function> map = new HashMap<>();
		map.put(1,(a)->do1(a));
		map.put(2,(a)->do2(a));
		System.out.println(map.get(2).apply("qqq"));
	}

	private static Object do1(Object a) {
		return "result1"+a;
	}
	private static Object do2(Object a) {
		return "result"+a;
	}
}
