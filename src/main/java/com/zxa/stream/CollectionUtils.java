package com.zxa.stream;

import com.zxa.bean.Student;

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

	public  static List<Student> getStudents(){
		Student student1 = new Student();
		student1.setAge(18);
		student1.setName("tt");
		Student student2 = new Student();
		student2.setAge(20);
		student2.setName("zxa");
		Student student3 = new Student();
		student3.setName("rr");
		student3.setAge(28);

		List<Student> list = new ArrayList<Student>(){{
			add(student1);
			add(student2);
			add(student3);
		}};



		return list;
	}




}
