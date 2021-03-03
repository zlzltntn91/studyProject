package training.chapter2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArrayTrainingTest {

    @Test
    public void arrayInit() {
        int[] array = {1, 2, 3, 4};
        assertThat(array.length, is(4));
    }

    @Test
    public void arrayInit2() {
        int[] array = {1, 2, 3, 4};
        int[] array2 = {1, 2, 3, 4};
        assertThat(array, is(equalTo(array2)));
        assertThat(array, is(array2));
    }

    @Test
    public void arrayInit3() {
        ArrayTraining arrayTraining = new ArrayTraining();
        int[] array = {1, 2, 3, 4};
        int[] array2 = {1, 2, 3, 4};
        assertThat(arrayTraining.equals(array, array2), is(true));
    }
}