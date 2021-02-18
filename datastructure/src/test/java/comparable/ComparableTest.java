package comparable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComparableTest implements Comparable<Integer>{

  /**
   * compareTo() 메서드 작성법
   * 현재 객체 < 파라미터로 넘어온 객체: 음수 리턴
   * 현재 객체 == 파라미터로 넘어온 객체: 0 리턴
   * 현재 객체 > 파라미터로 넘어온 객체: 양수 리턴
   * 음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
   *
   */

  @Override
  public int compareTo (Integer o) {
    return 0;
  }

  @Test
  public void test(){
      List<Integer> integerList = new ArrayList<>();
      ComparableTest comparableTest = new ComparableTest();
      integerList.add(12);
      integerList.add(16);
      integerList.add(9);
//    Collections.sort(integerList, this);
//      integerList.sort();
  }

}
