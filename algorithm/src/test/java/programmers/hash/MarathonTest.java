package programmers.hash;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 문제 설명
 * <p>
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다.
 * 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * <p>
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant
 * 완주한 선수들의 이름이 담긴 배열 completion
 * <p>
 * 완주하지 못한 선수의 이름을 return
 * <p>
 * 제한사항
 * <p>
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 */
@Slf4j
public class MarathonTest {

	@Test
	public void solution() {

		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};

		Map<String, Integer> map = new HashMap<>();

		for (String runner : participant) {
			map.compute(runner, (k, v) -> v == null ? 0 : --v);
		}

		System.out.println(map);

		for (String complete : completion) {
			map.computeIfPresent(complete, (k, v) -> ++v);
		}

		System.out.println(map);

		String result = map.entrySet()
				.stream()
				.map(v -> {
						 if (v.getValue().intValue() == 0) {
							 return v.getKey();
						 }
						 return "";
					 }
				).collect(Collectors.joining());

		System.out.println(result);
	}

	public String solution(String[] participant, String[] completion) {
		String answer = "";
		return answer;
	}
}