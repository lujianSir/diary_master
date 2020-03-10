package com.bwsk.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Utils {

	// 获取当前的时间(年月日，时分秒)
	public static String getCurrent() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String currentTime = df.format(new Date());// new Date()为获取当前系统时间
		return currentTime;
	}

	// 获取当前的时间(年月日)
	public static String getCurrentYMD() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");// 设置日期格式
		String currentTime = df.format(new Date());// new Date()为获取当前系统时间
		return currentTime;
	}

	// 获取当前的年月
	public static String getCurrentMouth() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月");// 设置日期格式
		String currentTime = df.format(new Date());// new Date()为获取当前系统时间
		return currentTime;
	}

	/**
	 * 时间戳转换成日期格式字符串
	 * 
	 * @param seconds   精确到秒的字符串
	 * @param formatStr
	 * @return
	 */
	public static String timeStampDate(String seconds, String format) {
		if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
			return "";
		}
		if (format == null || format.isEmpty()) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(seconds + "000")));
	}

	/**
	 * 时间戳转换成日期格式字符串(转为年月日)
	 * 
	 * @param seconds   精确到秒的字符串
	 * @param formatStr
	 * @return
	 */
	public static String timeStampDate2(String seconds, String format) {
		if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
			return "";
		}
		if (format == null || format.isEmpty()) {
			format = "yyyy年MM月dd日";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(seconds + "000")));
	}

	/**
	 * 取得当前时间戳（精确到秒）
	 * 
	 * @return
	 */
	public static String timeStamp() {
		long time = System.currentTimeMillis();
		String t = String.valueOf(time / 1000);
		return t;
	}

	/**
	 * 两个时间之间相差距离多少天
	 * 
	 * @param one 时间参数 1：
	 * @param two 时间参数 2：
	 * @return 相差天数
	 */
	public static String getDistanceDays(String starttime, String endtime) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date one;
		Date two;
		long days = 0;
		String str = "";
		try {
			one = df.parse(starttime);
			two = df.parse(endtime);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff;

			if (time1 < time2) {
				diff = time2 - time1;
				str = "违约";
			} else {
				diff = time1 - time2;
				str = "还有";
			}
			days = diff / (1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String s = str + days + "天";
		return s;// 返回相差多少天
	}

	public static void main(String[] args) throws Exception {
//		String startday = "2020-04-08";// 到期时间
//		String endday = "2020-03-13";// 当前时间
//		String DistanceDays = getDistanceDays(startday, endday);// 两个时间之间相差距离多少天
//		System.out.println(DistanceDays);
		String timeStamp = timeStamp();
		String date = timeStampDate(timeStamp, null);
		String date2 = timeStampDate2(timeStamp, null);
		System.out.println(date);
		System.out.println(date2);
	}
}
