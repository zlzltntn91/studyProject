package practice;

public class Chapter1 {

  // p1
  public int min3 (int a, int b, int c) {
    int min = a;
    if (min > b) {
      min = b;
    }
    if (min > c) {
      min = c;
    }
    return min;
  }

  //p2
  public int max4 (int a, int b, int c, int d) {
    int max = a;
    if (max < b) {
      max = b;
    }
    if (max < c) {
      max = c;
    }
    if (max < d) {
      max = d;
    }
    return max;
  }

  //p3
  public int min4 (int a, int b, int c, int d) {
    int min = a;
    if (min > b) {
      min = b;
    }
    if (min > c) {
      min = c;
    }
    if (min > d) {
      min = d;
    }
    return min;
  }

}
