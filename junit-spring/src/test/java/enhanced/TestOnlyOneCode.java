package enhanced;

import lombok.Getter;
import lombok.Setter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestOnlyOneCode {
  Duck duck;

  @Before
  public void setUp(){
    duck = new Duck();
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullColor_ExpectedIllegalArgumentException(){
    duck = new Duck(null, "청둥오리");
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullName_ExpectedIllegalArgumentException(){
    duck = new Duck("노란색", null);
  }

  @Test
  public void CorrectValueSayMyNameTest(){
    duck = new Duck("청록색", "청둥오리");
    assertThat(duck.sayMyName(), is("청둥오리"));
  }

}

@Setter
@Getter
class Duck {

  private String color;
  private String name;

  Duck( ){

  }

  public Duck (String color, String name) {
    if(color == null) { throw new IllegalArgumentException("color is Null"); }
    if(name == null) { throw new IllegalArgumentException("name is Null"); }
    this.color = color;
    this.name = name;
  }

  String sayMyName() {
    return this.getName();
  }

}
