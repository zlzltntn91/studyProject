package basic.springtest.sub;

import basic.springtest.CJunitSpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SubJunitSpringTest extends CJunitSpringTest {

  @Test
  public void test () {
    log.debug("sub");
  }

}
