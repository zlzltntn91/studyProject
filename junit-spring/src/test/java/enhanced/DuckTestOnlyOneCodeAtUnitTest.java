package enhanced;

import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

// 4. Duck 클래스를 한번에 한가지 기능만 테스트 하도록 만들기
//
//    1. 실패하는 테스트 부터 작성해보기
//    2. 실패하는 테스트를 성공할 수 있도록 리펙토링 하기
//    3. 하나의 단위 테스트에 하나의 어설션만 수행하기
//
// 5. private 접근 제한자 변수, 메서드 테스트 하는 방법
public class DuckTestOnlyOneCodeAtUnitTest {


}

class Duck {

  private final String color;
  private final String name;

  Duck (String color, String name) {
    this.color = color;
    this.name = name;
  }

  String sayMyName() {
    return name;
  }

  String sayMyColor() {
    return color;
  }
}

















//  private String description(){
//    return name + "은(는) 색상이 " + color + "이다.";
//  }

//  @Test
//  @SneakyThrows
//  public void privateFieldTest_color(){
//    Duck duck = new Duck("흰색", "북경오리");
//    Field field = duck.getClass().getDeclaredField("color");
//    field.setAccessible(true);
//    String color = (String) field.get(duck);
//    assertThat(color, is(equalTo("흰색")));
//  }

//  @Test
//  @SneakyThrows
//  public void descriptionTest() {
//    Duck duck = new Duck("노란색", "러버덕");
//    Method method = duck.getClass().getDeclaredMethod("description");
//    method.setAccessible(true);
//    String result = (String) method.invoke(duck);
//    assertThat(result, is(equalTo("러버덕은(는) 색상이 노란색이다.")));
//  }




