package com.zxa.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: StreamDemo
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/26 9:28
 */
public class StreamDemo {
	private static String[] strings = new String[]{"zxa","yt", "sss", "zzz", "tt", "yy"};

	public static void main(String[] args) {


		System.out.println("================map() start=====================");
		map();
		System.out.println("================map() end=====================");


		System.out.println("================flatMap() start=====================");
		flatMap();
		System.out.println("================flatMap() end=====================");


	}

	/**
	 * @description //一对多转换，流的扁平化
	 * @method  testflatMap
	 * @params  []
	 * @return void
	 * @date: 2018/11/26 10:31
	 * @author:zhangxin_an
	 */
	private static void flatMap() {
		String[][] strings = new String[][]{{"zxa", "zxa2"}, {"qq", "qq1", "qq2"}, {"tt", "tt1", "tt3"}};

		List l = Stream.of(strings).flatMap( strings1 -> Arrays.stream(strings1)).filter( a -> a.contains("1")).collect(Collectors.toList());
		System.out.println(l);
	}

	/**
	 * @description //实现一对一映射转换
	 * @method  testMap
	 * @params  []
	 * @return void
	 * @date: 2018/11/26 10:32
	 * @author:zhangxin_an
	 */
	private static void map() {
		List<String> list ;
		System.out.println("map实现转换大写");
		list = Arrays.asList(strings).stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(list);

		List<Integer> integers = new ArrayList<Integer>(){{
			add(1);
			add(2);
			add(3);
			add(4);
		}
		};
		System.out.println("计算平方");
		integers = integers.stream().map( n -> n * n).collect(Collectors.toList());
		System.out.println(integers);
	}


	private static void print(List<String> list){
		list.forEach(System.out::print);
	}


}
