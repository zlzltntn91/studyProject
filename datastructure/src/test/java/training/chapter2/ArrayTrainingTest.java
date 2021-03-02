package training.chapter2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArrayTrainingTest {

  @Test
  public void arrayInit(){
    int [] array = {1, 2, 3, 4};
    assertThat(array.length, is(4));
  }

  @Test
  public void arrayInit2(){

  }

  @Test
  public void arrayInit3(){

  }

}