package training.chapter2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CardinalNumberTrainingTest {

	@Test
	public void solutionTest(){
		CardinalNumberTraining cardinalNumberTraining = new CardinalNumberTraining();
		assertThat(cardinalNumberTraining.solution(59, 2), is(1010));
	}

}