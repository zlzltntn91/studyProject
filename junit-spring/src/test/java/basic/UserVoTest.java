package basic;

import junit.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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

  @Test
  public void setChoiUserVo () {
    user.setName("최은수");
    user.setId("choies");
    user.setEmail("choies@digitalzone.co.kr");
    assertThat(user.getName(), is("최은수"));
  }

  @Test
  public void userVoTest () {
    assertThat(user.getName(), is("김은수"));
    assertThat(user.getId(), is("kimes"));
    assertThat(user.getEmail(), is("kimes@digitalzone.co.kr"));
  }

  @Test(expected = AssertionError.class)
  public void illegalUserTest () {
    assertThat(user.getName(), is("이은수"));
  }

  @Test
  public void setUserVoTest () {
    assertThat(user.getName(), is("최은수"));
  }

}
