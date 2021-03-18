package programmers.hash;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 문제 설명
 *
 * 		수많은 마라톤 선수들이 마라톤에 참여하였습니다.
 * 		단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 * 		
 * 		마라톤에 참여한 선수들의 이름이 담긴 배열 participant
 * 		완주한 선수들의 이름이 담긴 배열 completion
 *
 * 		완주하지 못한 선수의 이름을 return
 *
 * 제한사항
 * 
 * 		마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * 		completion의 길이는 participant의 길이보다 1 작습니다.
 * 		참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 		참가자 중에는 동명이인이 있을 수 있습니다.
 */
@Slf4j
public class MarathonTest {

	@Test
	public void solution() {
		String[] participant = {"leo", "kiki", "eden", "kiki"};
		String[] completion = {"eden", "kiki"};


	}

	public String solution(String[] participant, String[] completion) {
		String answer = "";
		return answer;
	}
}