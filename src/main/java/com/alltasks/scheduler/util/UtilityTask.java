package com.alltasks.scheduler.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UtilityTask {
	
	public enum Priority {
	    HIGH, LOW,MEDIUM;

	public static Priority getPriority(){
	    Priority[] pri = Priority.values();
	    Random generator = new Random();
	    return pri[generator.nextInt(pri.length)];
	    }
	}
	
	public static String getCurrentDateTimeFormatted() {
		  SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
	        Date now = new Date();
	         String strDate = sdfDate.format(now);
	         return strDate;
	}
	
}
