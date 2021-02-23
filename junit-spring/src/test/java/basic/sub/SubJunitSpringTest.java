package basic.sub;

import basic.JunitSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SubJunitSpringTest extends JunitSpringTest {

  @Test
  public void test () {
    log.debug("sub");
  }

}
