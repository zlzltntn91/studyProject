package stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ImStackTest {

  WithoutExampleMakeStackByList<String> stack;

  @Before
  public void before () {
    stack = new WithoutExampleMakeStackByList<>();
    stack.push("Hello1");
    stack.push("Hello2");
    stack.push("Hello3");
    stack.push("Hello4");
    stack.push("Hello5");
    stack.push("Hello6");
  }

  @Test
  public void getSize () {
    assertThat(stack.getSize(), is(6));
  }

  @Test
  public void popTest () {
    assertThat(stack.pop(), is("Hello6"));
    assertThat(stack.pop(), is("Hello5"));
    assertThat(stack.pop(), is("Hello4"));
    stack.pop();
    assertThat(stack.pop(), is("Hello2"));
    assertThat(stack.getSize(), is(1));
  }
}