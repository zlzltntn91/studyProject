package strategyPatttern;

import strategyPatttern.context.Context;
import strategyPatttern.strategy.StrategyImpl2;
import strategyPatttern.strategy.StrategyImpl3;

public class Client {
  public static void main (String[] args) {
    Context context = new Context();
    context.setStrategy(new StrategyImpl2());
    context.excute();
    context.setStrategy(new StrategyImpl3());
    context.excute();
  }
}
