package com.wenance.Challenge.wenance.Challenge.util;

import java.text.SimpleDateFormat;

public interface CalorieTrackingConstant {
	final String REQUEST_DATE_FORMAT = "yyyy-mm-dd HH:mm:ss";
	final String RESPONSE_DATE_FORMAT = "yyyy-mm-dd HH:mm:ss";
	final SimpleDateFormat formatter = new SimpleDateFormat(REQUEST_DATE_FORMAT);
	final SimpleDateFormat displayFormatter = new SimpleDateFormat(RESPONSE_DATE_FORMAT);
}
