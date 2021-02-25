package basic.hamcrest;

import junit.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.beans.HasProperty.hasProperty;


@Slf4j
public class Hamcrest {

  @Test
  public void coreTest () {
    assertThat("Hello Hamcrest", anything());
    assertThat(2021, anything());
    assertThat(null, anything());

    assertThat("Hello Hamcrest", is("Hello Hamcrest"));
  }

  @Test
  public void logicalTest () {
    assertThat("Hello Hamcrest", is(allOf(notNullValue(), instanceOf(String.class))));
    assertThat(2021, is(allOf(notNullValue(), instanceOf(Integer.class))));

    assertThat("Hello Hamcrest", is(anyOf(notNullValue(), instanceOf(Integer.class))));
    assertThat(2021, is(anyOf(nullValue(), instanceOf(Integer.class))));

    assertThat("Hello Hamcrest", is(not(instanceOf(Integer.class))));
    assertThat(2021, is(not(nullValue())));
  }

  @Test
  public void objectsTest () {
    User user1 = new User();
    user1.setName("김은수");

    assertThat(user1, is(instanceOf(User.class)));
    assertThat(user1, is(notNullValue()));
  }

  @Test
  public void beanTest () {
    assertThat(new User(), is(hasProperty("id")));
    assertThat(new User(), is(hasProperty("email")));
    assertThat(new User(), is(hasProperty("age")));
  }

  @Test
  public void collectionTest () {
    List<String> testList = new ArrayList<>();
    testList.add("김");
    testList.add("이");
    testList.add("박");
    testList.add("최");
    testList.add("정");
    assertThat(testList, hasItem("김"));
    assertThat(testList, is(not(hasItem("유"))));
  }

  @Test
  public void textTest () {
    String name = "kimeunsoo";
    String camelName = "KimEunSoo";
    assertThat(name, is(equalToIgnoringCase(camelName)));

    String withoutWhiteSpaceName = "KIM EUN SOO";
    String withWhiteSpaceName = "       KIM       EUN                SOO         ";
    assertThat(withWhiteSpaceName, is(equalToIgnoringWhiteSpace(withoutWhiteSpaceName)));
  }
}
