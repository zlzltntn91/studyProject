package search;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

@Slf4j
public class BinarySearch {

	@Test
	@Ignore
	public void shift() {
		int i = 10;
		log.info(Integer.toBinaryString(i)); // 1010
		log.info(Integer.toBinaryString(i >>> 1)); //101
		int j = 20;
		log.debug(String.valueOf(i >>> 1));
	}

	public int binarySearch_int(int[] targetArray, int targetNum) {
		int beginPoint = 0;
		int endPoint = targetArray.length - 1;
		int count = 0;
		while (beginPoint <= endPoint) {
			count++;
			int middlePoint = (beginPoint + endPoint) / 2;
			if (targetNum == targetArray[middlePoint]) {
				log.info(count + "");
				return 1;
			} else {
				if (targetNum < targetArray[middlePoint]) {
					endPoint = middlePoint - 1;
				} else {
					beginPoint = middlePoint + 1;
				}
			}
		}
		log.info(count + "");
		return -1;
	}

	public boolean binarySearch_boolean(int[] arr, int target) {
		int from = 0;
		int to = arr.length - 1;
		int count = 0;
		while(from <= to){
			count++;
			int mid = (from + to) / 2;
			if(target < arr[mid]){
				to = mid - 1;
			}else if(arr[mid] < target){
				from = mid + 1;
			}else{
				log.info(count + "");
				return true;
			}
		}
		log.info(count + "");
		return false;
	}

	@Test
	public void name() {
		Linear_SequentialSearch linear_sequentialSearch = new Linear_SequentialSearch();
		int target =  5;
		int[] array = new Random().ints(10, 0, 10).toArray();
		Arrays.sort(array);

		long s = System.currentTimeMillis();
//		log.info("이진 탐색 결과 : {} time : {}", binarySearch_int(array, target), System.currentTimeMillis() - s);
		s = System.currentTimeMillis();
		log.info("이진 탐색 결과 : {} time : {}", binarySearch_boolean(array, target), System.currentTimeMillis() - s);
//		s = System.currentTimeMillis();
//		log.info("Arrays.binarySearch 결과 : {} time : {}", Arrays.binarySearch(array, target), System.currentTimeMillis() - s);
//		s = System.currentTimeMillis();
//		log.info("선형 탐색 결과 : {} time : {}", linear_sequentialSearch.linear(target, array), System.currentTimeMillis() - s);
	}
}
