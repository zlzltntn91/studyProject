package strategyPatttern.strategy;

public class StrategyImpl1 implements Strategy {
  @Override
  public void strategyMethod () {
    System.out.println("8서플-10배럭-11.5배럭-14서플-17서플-앞마당");
  }

  @Override
  public String toString () {
    return "투배럭더블";
  }
}
