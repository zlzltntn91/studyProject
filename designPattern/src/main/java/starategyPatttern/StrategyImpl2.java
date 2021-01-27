package starategyPatttern;

public class StrategyImpl2 implements Strategy {
  @Override
  public void strategyMethod () {
    System.out.println("투팩-아머리-스타포트-머신샵(1개만)-탱크-골리앗-스타포트 컨트롤타워 건설-드랍쉽 생산");
  }

  @Override
  public String toString () {
    return "투팩 골리앗 드랍";
  }
}
