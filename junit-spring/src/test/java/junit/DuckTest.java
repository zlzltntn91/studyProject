package junit;

import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class DuckTest {

  @Test(expected = IllegalArgumentException.class)
  public void constructorTest_firstParameterIsNull(){
    Duck duck = new Duck(null, "청둥오리");
    assertThat(duck, is(notNullValue()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyStringTest(){
    Duck duck = new Duck("", "청둥오리");
    assertThat(duck, is(notNullValue()));
  }

  @Test
  public void sayMyNameTest() {
    Duck duck = new Duck("빨", "hi");
    assertThat(duck.sayMyName(), is(equalTo("hi")));
  }

  @Test(expected = AssertionError.class)
  public void sayMyNameFailTest() {
    Duck duck = new Duck("black", "hi");
    assertThat(duck.sayMyName(), is(equalTo("")));
  }

  @Test(expected = IllegalArgumentException.class)
  public void colorTypeTest(){
    Duck duck = new Duck("11", "test");
  }




  @Test
  @SneakyThrows
  public void privateFieldTest_color(){
    Duck duck = new Duck("빨", "북경오리");
    Field field = duck.getClass().getDeclaredField("color");
    field.setAccessible(true);
    String color = (String) field.get(duck);
    assertThat(color, is(equalTo("빨")));
  }

  @Test
  @SneakyThrows
  public void descriptionTest() {
    Duck duck = new Duck("빨", "러버덕");
    Method method = duck.getClass().getDeclaredMethod("description");
    method.setAccessible(true);
    String result = (String) method.invoke(duck);
    assertThat(result, is(equalTo("러버덕은(는) 색상이 빨이다.")));
  }

}

