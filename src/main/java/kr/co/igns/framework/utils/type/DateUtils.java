package kr.co.igns.framework.utils.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	public static final String DB_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String getFolderDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		return formatter.format(new Date());
	}

	public static String getNowDate() {
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat sdfCurrent = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdfCurrent.format(today);
	}

	public static String getNowDate(String format) {
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat sdfCurrent = new SimpleDateFormat(format);
		return sdfCurrent.format(today);
	}

	public static String convertLongToDateString(Long dateLong) {
		if (dateLong != null && dateLong != 0L) {
			Date date = new Date(dateLong);
			SimpleDateFormat sdfCurrent = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdfCurrent.format(date);
		} else {
			return null;
		}
	}

	public static Date getDateByFormat(String date, String format) throws Exception {
		SimpleDateFormat sdfCurrent = new SimpleDateFormat(format);
		return sdfCurrent.parse(date);
	}

	public static String getDateByFormat(Date date, String format) throws Exception {
		SimpleDateFormat sdfCurrent = new SimpleDateFormat(format);
		return sdfCurrent.format(date);
	}

	public static String getDateByFormatToString(String date, String originFormat, String toFormat)
			throws ParseException {
		SimpleDateFormat sdfCurrent = new SimpleDateFormat(originFormat);
		Date tempDate = sdfCurrent.parse(date);
		sdfCurrent = new SimpleDateFormat(toFormat);
		return sdfCurrent.format(tempDate);
	}

	public static String addYearMonthDay(String sDate, int year, int month, int day) {
		String dateStr = validChkDate(sDate);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());

		try {
			cal.setTime(sdf.parse(dateStr));
		} catch (ParseException var8) {
			throw new IllegalArgumentException(dateStr);
		}

		if (year != 0) {
			cal.add(1, year);
		}

		if (month != 0) {
			cal.add(2, month);
		}

		if (day != 0) {
			cal.add(5, day);
		}

		return sdf.format(cal.getTime());
	}

	public static String validChkDate(String dateStr) {
		String _dateStr = dateStr;
		if (dateStr != null && (dateStr.trim().length() == 8 || dateStr.trim().length() == 10)) {
			if (dateStr.length() == 10) {
				_dateStr = replace(dateStr, "-", "");
			}

			return _dateStr;
		} else {
			throw new IllegalArgumentException(dateStr);
		}
	}

	public static String replace(String str, String oldStr, String newStr) {
		StringBuffer sb = new StringBuffer();
		int savedPos = 0;

		do {
			int pos = str.indexOf(oldStr, savedPos);
			if (pos == -1) {
				break;
			}

			sb.append(str.substring(savedPos, pos));
			sb.append(newStr);
			savedPos = pos + oldStr.length();
		} while (savedPos < str.length());

		sb.append(str.substring(savedPos, str.length()));
		return sb.toString();
	}

	public static boolean isThisDateValid(String dateToValidate, String dateFromat) {
		if (dateToValidate == null) {
			return false;
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
			sdf.setLenient(false);

			try {
				sdf.parse(dateToValidate);
				return true;
			} catch (ParseException var4) {
				return false;
			}
		}
	}

	public static String timeStamp(int size) {
		return timeStamp().substring(0, size);
	}

	public static String getLogTimeStamp() {
		return timeStamp().substring(0, 14);
	}

	public static String timeStamp() {
		return timeStamp("yyyyMMddHHmmssSSS");
	}

	public static String timeHHmmss() {
		return timeStamp("yyyyMMddHHmmss");
	}

	public static String timeStamp(String format) {
		return (new SimpleDateFormat(format)).format((new GregorianCalendar()).getTime());
	}

	public static String timeStamp(String format, long date) {
		return (new SimpleDateFormat(format)).format(new Date(date));
	}

	public static String getSessionId() {
		long temp = Math.round(Math.random() * 1000.0D);
		timeStamp();
		return String.format("%04d", temp);
	}

	public static Date nowToDate() {
		return Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHours(9)));
	}

	public static Date nowAfterSecondsToDate(Long seconds) {
		return Date.from(LocalDateTime.now().plusSeconds(seconds).toInstant(ZoneOffset.ofHours(9)));
	}

	public static Date nowAfterHoursToDate(Long days) {
		return Date.from(LocalDateTime.now().plusHours(days).toInstant(ZoneOffset.ofHours(9)));
	}

	public static Date nowAfterDaysToDate(Long days) {
		return Date.from(LocalDateTime.now().plusDays(days).toInstant(ZoneOffset.ofHours(9)));
	}
	
	public long getTimeDifference(String time1, String time2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+09:00");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = sdf.parse(time1);
			d2 = sdf.parse(time2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long diff = d1.getTime() - d2.getTime();
		long sec = diff / 1000;
		System.out.println("getTimeDifference : " + sec);
		return sec;
	}
}