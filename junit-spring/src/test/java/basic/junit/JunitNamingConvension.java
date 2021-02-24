package basic.junit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 2. 테스트 클래스가 정상 실행 가능하도록 고쳐야 할 부분 찾기
 */
@Slf4j
// 1
class JunitNamingConvension {

  // 2
  @Test
  void test1(){
    log.debug("im default access modifier");
  }

  // 3
  @Test
  public String test2(){
    log.debug("return type is String");
    return "";
  }

  // 4
  @Test
  public void test3(String name){
    log.debug("test3 method with Parameter {}", name);
  }

  // 5
  @Test
  public static void test4(){
    log.debug("im static method");
  }

}
