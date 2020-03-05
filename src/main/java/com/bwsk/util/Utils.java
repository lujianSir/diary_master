package com.bwsk.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	//获取当前的时间
	public static String getCurrent() {
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		  String currentTime=df.format(new Date());// new Date()为获取当前系统时间       
          return currentTime;
	}
	
	public static void main(String[] args) {
		System.out.println(Utils.getCurrent());
	}
}
