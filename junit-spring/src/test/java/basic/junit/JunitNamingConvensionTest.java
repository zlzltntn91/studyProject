package basic.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 2. 테스트 클래스가 정상 실행 가능하도록 고쳐야 할 부분 찾기
 */
@Slf4j
// 1
public class JunitNamingConvensionTest {

  // 2
  @Test
  public void test1(){
    log.debug("im default access modifier");
  }

  // 3
  @Test
  public void test2(){
    log.debug("return type is String");
  }

  // 4
  @Test
  public void test3(){
    log.debug("test3 method with Parameter {}");
  }

  // 5
  @Test
  public void test4(){
    log.debug("im static method");
  }

}
