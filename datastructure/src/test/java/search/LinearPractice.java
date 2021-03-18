package search;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
public class LinearPractice {

	String bar = "----";

	@Test
	public void q2() {
		int target = 3;
		int[] arr = new int[5];

		StringBuilder sb = new StringBuilder("\t|\t");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(10);
			sb.append(i + "\t");
		}
		log.info(sb.toString());

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				log.info(bar + "+" + getBar(arr.length));
			}
			log.info("    |" + getStar(i));
			log.info("  " + i + " |\t" + Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("\t")));
			if (arr[i] == target){
				log.info("{} 은 x[{}]에 있음.", target, i);
				break;
			}
		}
	}

	String getBar(int size) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(bar);
		}
		return sb.toString();
	}

	String getStar(int idx) {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < idx; i++) {
			sb.append("\t");
		}
		return sb.append("\t", 0, 1).append("*").toString();
	}
}
