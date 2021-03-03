package training.chapter2;

import org.apache.commons.lang3.StringUtils;

public class CardinalNumberTraining {
	public String solution(int i, int cardinal) {
		String result;
		int mok = i;
		StringBuilder resultBuilder = new StringBuilder();

		while (mok / cardinal != 0) {
			String remind = String.valueOf(mok % cardinal);
			if (Integer.parseInt(remind) >= 10 && cardinal == 16) {
				char[] digits = {'A', 'B', 'C', 'D', 'E', 'F'};
				remind = String.valueOf(digits[Integer.parseInt(remind) - 10]);
			}
			resultBuilder.append(remind);
			mok /= cardinal;
		}
		result = resultBuilder.toString();

		if (mok >= 10 && cardinal == 16) {
			char[] digits = {'A', 'B', 'C', 'D', 'E', 'F'};
			result += digits[mok - 10];
		} else {
			result += mok;
		}

		result = StringUtils.reverse(result);
		return result;
	}


}
