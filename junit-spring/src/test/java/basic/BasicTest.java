package basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;

@Slf4j
public class BasicTest {

  @BeforeClass
  public static void beforeClass () {
    log.debug("beforeClass");
  }

  @AfterClass
  public static void afterClass () {
    log.debug("afterClass");
  }

  @Before
  public void setUp () {
    log.debug("setUp");
  }

  @After
  public void tearDown () {
    log.debug("tearDown");
  }

  @Test
  public void atestMethod () {
    log.debug("김");
  }

  @Test
  public void btestMethod () {
    log.debug("은");
  }

  @Test
  public void ctestMethod () {
    log.debug("수");
  }
}
