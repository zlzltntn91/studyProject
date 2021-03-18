package training.search.chapter2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Slf4j
public class LeapYearTrainingTest {

	private final int[][] yearArray = new int[][]{
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
	};

	@Test(expected = IllegalArgumentException.class)
	public void getLeapYear_param202_expectedIllegal() {
		boolean isLeapYear = getLeap(202);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getLeapYear_param0_expectedIllegal() {
		boolean isLeapYear = getLeap(0);
	}

	@Test
	public void getLeapYear_param2000_expectedTrue() {
		boolean isLeapYear = getLeap(2000);
		assertThat(isLeapYear, is(true));
	}

	@Test
	public void getArray() {
		assertThat(yearArray.length, is(2));
		assertThat(yearArray[0].length, is(12));
		assertThat(yearArray[1].length, is(12));
	}

	@Test
	public void getDayOfYear_param20190315_expected74() {
		int result = getDayOfYear("20191230");
		assertThat(result, is(364));
	}

	@Test
	public void subStringTest_paramIs20190315_expected2019() {
		String s = "20190315";
		s = s.substring(0, 4);
		assertThat(s, is("2019"));
	}

	@Test
	public void getYMD_param19910102_expected1991_01_02() {
		int[] ymd = getYMD("19910102");
		int[] expected = {1991, 01, 02};
		assertThat(ymd.length, is(3));
		assertThat(ymd, is(equalTo(expected)));
	}

	@Test(expected = NumberFormatException.class)
	public void getYMD_expectedNumberForExc() {
		int[] ymd = getYMD("19c1이야0ㄹ");
	}

	private int[] getYMD(String s) {
		if (s.length() != 8) {
			throw new IllegalArgumentException();
		}
		int[] ymd = new int[3];
		try {
			ymd[0] = Integer.parseInt(s.substring(0, 4));
			ymd[1] = Integer.parseInt(s.substring(4, 6));
			ymd[2] = Integer.parseInt(s.substring(6));
		} catch (NumberFormatException e) {
			log.error("{} 는 int형으로 변환 할 수 없음", s);
			throw new NumberFormatException();
		}
		return ymd;
	}

	private int getDayOfYear(String s) {
		int result = 0;
		int year = Integer.parseInt(s.substring(0, 4));
		int month = Integer.parseInt(s.substring(4, 6));
		int days = Integer.parseInt(s.substring(6));
		int isLeapYear = getLeap(year) ? 1 : 0;

		for (int i = 0; i < month - 1; i++) {
			result += yearArray[isLeapYear][i];
		}

		result += days;
		return result;
	}


	private boolean getLeap(int year) {

		String sYear = String.valueOf(year);

		if (sYear.length() != 4) {
			throw new IllegalArgumentException();
		}

		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

}