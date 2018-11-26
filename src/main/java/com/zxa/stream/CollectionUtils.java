package com.zxa.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: CollectionUtils
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/26 9:29
 */
public class CollectionUtils {
	public  static <T> List<T> getList(T...objects){
		return new ArrayList<>(Arrays.asList(objects));
	}
}
