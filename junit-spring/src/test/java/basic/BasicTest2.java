package basic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class BasicTest2 {

  @Test
  public void test(){
    int a = 14;
    int b = 5;
    assertThat(a % b, is(0));
  }

}
