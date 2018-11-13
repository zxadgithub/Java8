package com.zxa.timedate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @Description:Java8时间日期
 * @Author: zhangxin_an
 * @CreateDate: 2018/8/30 14:35
 */
public class DateTimeN {

	public static void main(String[] args) {
		//当天日期
		LocalDate today = getToday();
		System.out.println("今天的日期是：(localDate)" + today);

		//分别获取年月日
		getTodayDate();

		//自定义日期
		getUserDefinedDate();

		//日期比较
		LocalDate first = LocalDate.now();
		LocalDate second = LocalDate.now();
		boolean flag = isEqualsDate(first, second);
		System.out.println(first + "和" + second + "比较结果" + flag);

		//检查周期性时间
		System.out.println("===========周期性时间===========");
		LocalDate dateOfBirth = LocalDate.of(1994, 9, 02);
		checkCyclicityDate(dateOfBirth);

		//获取当前时间
		LocalTime localTime = getCurrentTime();
		System.out.println("当前时间是：" + localTime);

		System.out.println("=====当前时间增加1小时==");
		System.out.println(localTime.plusHours(1));
		System.out.println("=======增加半天=========");
		System.out.println(localTime.plus(1, ChronoUnit.HALF_DAYS));

		System.out.println("=========时钟类========");
		testClock();

		System.out.println("时区转化");
		convertZone();

		System.out.println("检查闰年");
		System.out.println( today.isLeapYear());

		System.out.println("======计算日期差=====");

		Period period = diffDay(LocalDate.now(),LocalDate.now().plus(2,ChronoUnit.DAYS));
		System.out.println(period);


		System.out.println("====时间戳");
		System.out.println(Instant.now());

		System.out.println("日期格式化");
		String date = "2017-12-01";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ISO_DATE);
		System.out.println(localDate);


	}

	private static Period diffDay(LocalDate now, LocalDate plus) {
		return Period.between(now, plus);
	}

	private static void convertZone() {
		ZoneId america = ZoneId.of("America/New_York");
		LocalDateTime localDate = LocalDateTime.now();
		ZonedDateTime dateTime = ZonedDateTime.of(localDate,america);
		System.out.println("设置当前时间时区" + dateTime);
	}

	private static void testClock() {
		Clock clock = Clock.systemUTC();
		System.out.println(clock.millis());
		Clock clock1 = Clock.systemDefaultZone();
		System.out.println(clock.millis());
	}

	private static LocalTime getCurrentTime() {
		return LocalTime.now();
	}

	private static void checkCyclicityDate(LocalDate dateOfBirth) {
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		MonthDay currentDate = MonthDay.from(getToday());
		if (currentDate.equals(birthday)) {

			System.out.println("Many\n" +
					" Many happy returns of the day !!");
		} else {
			System.out.println("Sorry,today is not your birthday");
		}
	}

	private static boolean isEqualsDate(LocalDate first, LocalDate second) {
		return first.equals(second);
	}

	private static void getUserDefinedDate() {
		LocalDate userDefined = LocalDate.of(1994, 12, 29);
		System.out.println("自定义日期:" + userDefined);
	}

	/**
	 * 当天日期
	 */
	public static LocalDate getToday() {
		LocalDate today = LocalDate.now();
//		System.out.println(new Date());
		return today;
	}

	public static void getTodayDate() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.println("现在的日期是：" + year + "年" + month + "月" + day + "日");
	}


}
