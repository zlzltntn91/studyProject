package search;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

@Slf4j
public class BinaryPractice {

	/**
	 * 요소수 n인 배열 a에서 key와 일치하는
	 * 모든 요소의 인덱스를 찾아 배열 b에 앞부터 순서대로 저장
	 * 일치한 요솟수를 반환하는 메서드
	 * <p>
	 * e.g. {1,9,2,9,4,6,7,9} 배열에서 key가 9일 경우
	 * 배열 b에 {1. 3. 7} 을 저장하고, return 3
	 */
	@Test
	public void q3() {
		int[] arr = new int[]{1, 9, 2, 9, 4, 6, 7, 9, 9, 9, 9};
		int key = 9;
		StringBuilder tempStr = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				tempStr.append(i).append(",");
			}
		}
		int[] temp = Arrays.stream(tempStr.toString().split(","))
				.mapToInt(i -> Integer.parseInt(i))
				.toArray();
		log.info(Arrays.toString(temp));
		log.info("answer: {}", temp.length);
	}


	int binarySearch(int key, int[] arr) {
		log.info(Arrays.toString(arr));
		int result = -1;
		int from = 0;
		int to = arr.length;

		for (int i = from; i < to; i++) {
			int mid = (from + to) / 2;
			if (arr[mid] == key) {
				result = mid;
			} else if (arr[mid] < key) {
				from = mid + 1;
			} else {
				to = mid - 1;
			}
		}
		return to + 1;
	}

	@Test
	public void q6() {
		int[] arr = {1, 3, 5, 7, 9, 13, 19, 20, 42};
		log.info("삽입포인트 : {}" , binarySearch(10, arr));
	}

	@Test
	public void q5() {
	}
}
