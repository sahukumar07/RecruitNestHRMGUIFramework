package com.hrm.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	// random number generation
	public int getRandomNumber(int limit) {
		Random random = new Random();
		int randomNumber = random.nextInt(limit);
		return randomNumber;

	}

	// System date and time
	public String getSystemDateYYYYMMDD() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;

	}

	public String getRequiredDateYYYYDDMM(int days) {

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days); // DAY_OF_MONTH is a static method - sign is used for before date and
												// +sign is used for after 30 days.
		String reqDate = sim.format(cal.getTime());
		return reqDate;

	}

}
