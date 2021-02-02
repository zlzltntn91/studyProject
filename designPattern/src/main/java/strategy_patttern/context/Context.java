package strategy_patttern.context;

import strategy_patttern.strategy.Strategy;

public class Context {

  private Strategy strategy;

  public void excute () {
    System.out.println("─────────────────── " + this.strategy + " ───────────────────");
    strategy.strategyMethod();
  }

  public void setStrategy (Strategy strategy) {
    this.strategy = strategy;
  }
}
