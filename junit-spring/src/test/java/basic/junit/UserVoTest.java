package basic.junit;

import junit.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 3. 실패하는 테스트 찾기
 */
@Slf4j
public class UserVoTest {

  User user;

  @Before
  public void setUp () {
    user = new User();
    user.setName("김은수");
    user.setId("kimes");
    user.setEmail("kimes@digitalzone.co.kr");
  }

  // 1
  @Test
  public void setNameTest_expected최은수 () {
    user.setName("최은수");
    assertThat(user.getName(), is("최은수"));
  }

  // 2
  @Test(expected = AssertionError.class)
  public void getUserNameTest_expectedAssertionException () {
    assertThat(user.getName(), is("이은수"));
  }

  // 3
  @Test
  public void getUserName_expected최은수_Test () {
    assertThat(user.getName(), is("최은수"));
  }

  // 4
  @Test
  public void userListTest (){
    User user2 = new User();
    user2.setName("홍길동");

    List<User> userList = new ArrayList<>();
    userList.add(user);
    userList.add(user2);

    assertThat(userList, is(hasItems(user, user2)));
  }







  // 테스트 하나당 하나의 어설션만 수행할 것
  @Test
  public void threeAssertionTest () {
    assertThat(user.getName(), is("김은수"));
    assertThat(user.getId(), is("choi"));
    assertThat(user.getEmail(), is("kimes@digitalzone.co.kr"));
  }

}
