package basic.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runners.MethodSorters;

/**
 *  1. 실행순서 추측해보기
 */
@Slf4j
public class JunitFixture {

  @BeforeClass
  public static void beforeClass () {
    log.info("beforeClass");
  }
  
  @AfterClass
  public static void afterClass () {
    log.info("afterClass");
  }

  @Before
  public void setUp () {
    log.info("setUp");
  }

  @After
  public void tearDown () {
    log.info("tearDown");
  }

  @Test
  public void aTestMethod () {
    log.info("무");
  }

  @Test
  public void bTestMethod () {
    log.info("야");
  }

  @Test
  public void cTestMethod () {
    log.info("호");
  }

}
