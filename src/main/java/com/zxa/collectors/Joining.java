package com.zxa.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: Joining
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/13 17:33
 */
public class Joining {
	public static void main(String[] args) {
		final String[] names = {"Zebe", "Hebe", "Mary", "July", "David"};
		Stream<String> stream1 = Stream.of(names);
		Stream<String> stream2 = Stream.of(names);
		Stream<String> stream3 = Stream.of(names);
		//替换前缀，后缀以及分隔符
		String result1 = stream1.collect(Collectors.joining(",",  "[", "]"));
		String result2 = stream2.collect(Collectors.joining("|",  "[", "]"));
		String result3 = stream3.collect(Collectors.joining("->",  "[", "]"));
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
}
