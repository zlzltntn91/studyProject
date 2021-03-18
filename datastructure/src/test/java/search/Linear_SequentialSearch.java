package search;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Linear_SequentialSearch {

	public static void main(String[] args) {
		int[] targetArray = new int[100_000_000];
		for (int i = 0; i < 100_000_000; i++) {
			targetArray[i] = new Random().nextInt(100_000);
		}

		Linear_SequentialSearch linear_sequentialSearch = new Linear_SequentialSearch();
		log.info(linear_sequentialSearch.linear(98, targetArray));

		int[] targetArray2 = new int[100_000_001];
		for (int i = 0; i < 100_000_000; i++) {
			targetArray2[i] = new Random().nextInt(100_000);
		}
		log.info(linear_sequentialSearch.sentinel(98, targetArray2));

	}

	public String linear(int target, int[] array) {
		String result = "";
		int i = 0;
		for (; i < array.length; i++) {
			if (array[i] == target) {
				result = new String().format("array %s = %s", i, target);
			}
		}
		return result;
	}

	public String sentinel(int target, int[] array) {
		array[array.length - 1] = target;
		String result = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				result = new String().format("array [{%s}] == {%s}", i, target);
			}
		}
		return result;
	}
}
