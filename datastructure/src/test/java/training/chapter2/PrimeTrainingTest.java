package training.chapter2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PrimeTrainingTest {

	PrimeTraining primeTraining;

	@Before
	public void setPrimeTraining(){
		primeTraining = new PrimeTraining();
	}

	@Test
	public void rootTest(){
		int target = 11;
		int result = (int) Math.sqrt(target);
		assertThat(result, is(10));
	}

	@Test
	public void myVersion(){
		int result = primeTraining.solution1(1000);
		assertThat(result, is(1000)); // 2, 3, 5, 7
	}

	@Test
	public void myVersion2(){
		int result = primeTraining.solution2(1000);
		assertThat(result, is(168)); // 2, 3, 5, 7
	}

	@Test
	public void myVersion3(){
		int result = primeTraining.solution3(1000);
		assertThat(result, is(168)); // 2, 3, 5, 7
	}

}