package strategy_patttern.strategy;

public class StrategyImpl3 implements Strategy {
  @Override
  public void strategyMethod () {
    System.out.println("원게이트-어시밀레이터-사이버네틱스 코어-스타게이트");
  }

  @Override
  public String toString () {
    return "원게이트";
  }
}
