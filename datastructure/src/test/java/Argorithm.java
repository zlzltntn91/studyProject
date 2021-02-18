import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

@Slf4j
public class Argorithm {

  public static void main (String[] args) {
    log.debug("세 정수의 최대값 구하기");
    Scanner scanner = new Scanner(System.in);
    int [] numbers = new int[3];
    for (int i = 0; i < numbers.length; i++) {
      System.out.print("숫자 입력 : ");
      numbers[i] = scanner.nextInt();
    }
    // 방법 1
//    System.out.println(Arrays.stream(numbers).max());

    // 방법 2
    int max = numbers[0];
    if(max < numbers[1]){
      max = numbers[1];
    }
    if(max < numbers[2]){
      max = numbers[2];
    }
    System.out.println(max);


  }

  @Test
  public void basic () {
    log.debug("hello");
  }
}
