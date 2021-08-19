package com.wenance.Challenge.wenance.Challenge.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Component
@Slf4j
public class CalorieTrackingUtils implements CalorieTrackingConstant {



	/**
	 * This is to get Today as Date
	 * @return
	 */
	public static Date getTodayDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * This is to convert String to Date
	 * @param date
	 * @return
	 */
	public static Date toDate(String date) {
		if (Strings.isEmpty(date)) return null;
		try {
			return formatter.parse(date);
		}
		catch (Exception e) {
			log.error("There is an exception when parsing {}", date, e);
			return null;
		}
	}
	
	/**
	 * This is from Date to String
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return displayFormatter.format(date);
	}
}
