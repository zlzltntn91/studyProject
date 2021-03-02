package add;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddTest {

  @Test
  public void test(){
    Sum sum = new Sum();
    int result = sum.useWhile(10);
    assertThat(result, is(55));
  }

  @Test
  public void test2(){
    Sum sum = new Sum();
    assertThat(sum.useWhileLocalVariable(10), is(55));
  }

  @Test
  public void test3(){
    Sum sum = new Sum();
    assertThat(sum.useWhileLocalVariable(3), is(6));
  }


}