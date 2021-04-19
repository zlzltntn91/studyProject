package programmers.hash;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제 설명
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * <p>
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * <p>
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book solution 함수의 매개변수로 주어질 때,
 * <p>
 * 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를
 * 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한 사항
 * phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * 각 전화번호의 길이는 1 이상 20 이하입니다.
 * 같은 전화번호가 중복해서 들어있지 않습니다.
 * 입출력 예제
 */
@Slf4j
public class PhoneNumberList {

	@Test
	public void name() {
		String[] numbers = new String[]{"119", "119234", "56", "123", "78", "113", "112", "97674223"};
		Set<String> set = Arrays.stream(numbers).collect(Collectors.toCollection(HashSet::new));

		System.out.println(solution(numbers));
	}

	public boolean solution(String[] phone_book) {
			Set<String> set = Arrays.stream(phone_book).collect(Collectors.toCollection(HashSet::new));
		for (String n : phone_book) {
			set.remove(n);
			for (int i = 0; i < n.length(); i++) {
				if(set.contains(n.substring(0, i+1))){
					return false;
				}
			}
			set.add(n);
		}
		return true;
	}
}
