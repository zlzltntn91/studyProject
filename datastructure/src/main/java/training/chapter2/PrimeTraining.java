package training.chapter2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrimeTraining {

	/**
	 * i 까지의 소수의 개수
	 *
	 * @param i 범위
	 * @return
	 */
	public int solution1(int i) {
		int result = 0;
		int count = 0;
		for (int j = 2; j <= i; j++) {
			int k;
			for (k = 2; k < j; k++) {
				++count;
				if (j % k == 0) {
					break;
				}
			}
			if (j == k) {
				log.info("{} 는 소수", j);
				++result;
			}
		}
		log.info("나눈 횟 수 : {}", count);
		log.info("소수의 개수 : {}", result);
		return result;
	}

	public int solution2(int i) {
		int count = 0;
		int[] prime = new int[500];
		int pointer = 0;
		prime[pointer++] = 2;

		// 짝수는 제외 했으니까 prime[1] 부터 나눠보면 됨
		for (int j = 3; j <= i; j += 2) {
			int k;
			for (k = 1; k < pointer; k++) {
				count++;
				if (j % prime[k] == 0) {
					break;
				}
			}
			if (pointer == k) {
				prime[pointer++] = j;
			}
		}

		log.info("나눈 횟 수 : {}", count);
		log.info("소수의 개수 : {}", pointer);
		return pointer;
	}

	public int solution3(int targetNum) {

		boolean isPrimeNum;
		int sqrt;

		int count = 0;
		int arrayPointer = 0;
		int[] primeArray = new int[500];

		primeArray[arrayPointer++] = 2;

		for (int num = 3; num <= targetNum; num += 2) {
			isPrimeNum = true;
			sqrt = (int) Math.sqrt(num);
			int i;
			for (i = 0; primeArray[i] <= sqrt; i++) {
				++count;
				if (num % primeArray[i] == 0) {
					isPrimeNum = false;
					break;
				}
			}
			if (isPrimeNum) {
				primeArray[arrayPointer++] = num;
			}
		}

		log.info(arrayPointer + "");
		log.info(count + "");

		return arrayPointer;
	}

}
