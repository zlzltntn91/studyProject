package practice;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Chapter1Test {

  Chapter1 chapter1;

  @Before
  public void init(){
    chapter1 = new Chapter1();
  }

  @Test
  public void max4Test(){
    int result = chapter1.max4(23, 7, 3, 4);
    assertThat(result, is(23));
  }

  @Test
  public void min3Test(){
    int result = chapter1.min3(8,123,23);
    assertThat(result, is(8));
  }

  @Test
  public void min4Test(){
    int result = chapter1.min4(7,3,23, 1);
    assertThat(result, is(1));
  }

}