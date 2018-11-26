package com.zxa.stream;

import com.zxa.bean.Student;

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


		System.out.println("================filter() start=====================");
		filter();
		System.out.println("================filter() end=====================");

		System.out.println("================reduce() start=====================");
		reduce();
		System.out.println("================reduce() end=====================");


		System.out.println("================others start=====================");
		System.out.println("min()" + Stream.of(1, 2,2,3, 3).min(Integer::compareTo).get());
		System.out.println("max()" + Stream.of(1, 2, 3).max(Integer::compareTo).get());

		System.out.println("distinct()" + Stream.of(1, 2,2,3, 3).distinct().collect(Collectors.toList()));
		System.out.println("================others end=====================");

	}

	/**
	 * @description //作用是把 Stream 元素组合起来
	 * @method  reduce
	 * @params  []
	 * @return void
	 * @date: 2018/11/26 14:51
	 * @author:zhangxin_an
	 */
	private static void reduce() {
		//字符串链接，
		String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
		System.out.println(concat);

		//求最小值
		Double min = Stream.of(1d, -0.4d,1.3d, 34d, -9323d).reduce(Double.MAX_VALUE, Double::min);
		System.out.println(min);

		int sum = Stream.of(1, 2, 3, 4, 5).reduce(0, Integer::sum);
		System.out.println(sum);

		sum = Stream.of(1, 2, 3, 4, 5).reduce(Integer::sum).get();
		System.out.println(sum);
	}

	/**
	 * @description //对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream
	 * @method  filter
	 * @params  []
	 * @return void
	 * @date: 2018/11/26 14:51
	 * @author:zhangxin_an
	 */
	private static void filter() {
		System.out.println("学生年龄大于18");
		List<Student> list = CollectionUtils.getStudents();
		list = list.stream().filter(student -> student.getAge() > 18).collect(Collectors.toList());
		System.out.println(list);
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
