package com.zxa.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: CroupBy
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/13 17:19
 */
public class CroupBy {
	public static void main(String[] args) {
		Stream<String> stringStream = Stream.of("zxa", "ps", "idea", "yt", "mysql", "zd", "zj", "zl");
		final Map<Character, List<String>> map = stringStream.collect(Collectors.groupingBy( s -> s.charAt(0)));

		map.forEach((letter, groups) -> {
			System.out.println("以字母 " + letter + "开头的名字如下： ");
			groups.forEach( name -> {
				System.out.print("\t" + name);
			});
			System.out.println("\n");
		});
	}
}
