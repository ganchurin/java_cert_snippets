package core.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class DateTimeFormatterTest {

	@Test
	public void formatDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		LocalDate date = LocalDate.of(2015, Month.OCTOBER, 30);
		// Format date from formatter or from date
		assertEquals(formatter.format(date), "2015-10-30");
		assertEquals(date.format(formatter), "2015-10-30");
	}

	@Test
	public void formatTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
		LocalTime time = LocalTime.of(10, 30, 15, 1000);
		// Format time from formatter or from time
		assertEquals(formatter.format(time), "10:30:15.000001");
		assertEquals(time.format(formatter), "10:30:15.000001");
	}

	@Test
	public void formatDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTime dateTime = LocalDateTime.of(2015, Month.OCTOBER, 30, 10, 30, 15, 1000);
		// Format dateTime from formatter or from dateTime
		assertEquals(formatter.format(dateTime), "2015-10-30T10:30:15.000001");
		assertEquals(dateTime.format(formatter), "2015-10-30T10:30:15.000001");
	}

	@Test
	public void parseDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		assertEquals(LocalDate.parse("2015-10-30", formatter), LocalDate.of(2015, Month.OCTOBER, 30));
	}

	@Test
	public void parseTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
		assertEquals(LocalTime.parse("10:30:15", formatter), LocalTime.of(10, 30, 15));
	}

	@Test
	public void parseDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		LocalDateTime dateTime = LocalDateTime.of(2015, Month.OCTOBER, 30, 10, 30, 15);
		assertEquals(LocalDateTime.parse("2015-10-30T10:30:15", formatter), dateTime);
	}

	@Test
	public void formatDateWithCustomFormatter() {
		LocalDate date = LocalDate.of(2016, Month.JANUARY, 1);
		checkDateCustomFormatter(date, "yy/M/d", "16/1/1");
		checkDateCustomFormatter(date, "yy/M/dd", "16/1/01");
		checkDateCustomFormatter(date, "yy/MM/dd", "16/01/01");
		checkDateCustomFormatter(date, "yyyy/MMM/dd", "2016/Jan/01");
	}

	private void checkDateCustomFormatter(LocalDate date, String pattern, String expected) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.US);
		assertEquals(date.format(formatter), expected);
	}
}
