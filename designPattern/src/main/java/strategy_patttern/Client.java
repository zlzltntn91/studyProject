package strategy_patttern;

import lombok.extern.slf4j.Slf4j;
import strategy_patttern.context.Context;
import strategy_patttern.strategy.StrategyImpl2;
import strategy_patttern.strategy.StrategyImpl3;

@Slf4j
public class Client {
  public static void main (String[] args) {
    Context context = new Context();
    context.setStrategy(new StrategyImpl2());
    context.excute();
    context.setStrategy(new StrategyImpl3());
    context.excute();
  }
}
