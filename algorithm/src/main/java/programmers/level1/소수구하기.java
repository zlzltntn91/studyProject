package programmers.level1;

public class 소수구하기 {

  public static void main (String[] args) {
    소수구하기 solution = new 소수구하기();
    System.out.println(solution.solution(5)); // 2357
  }

  // 1과 n 사이의 소수 구하기
  public int solution (int n) {
    int answer = n - 1 ;
    if ((n % (n / 2) == 0)) {
      answer--;
    }else{
      for (int i = 2; i <= n; i++) {
        int divideCount = 0;
        for (int j = 1; j <= i; j++) {
          if (i % j == 0) {
            divideCount++;
          }
          if (divideCount > 2) {
            answer--;
            break;
          }
        }
      }
    }
    return answer;
  }
}

