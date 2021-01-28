package strategyPatttern.context;

import strategyPatttern.strategy.Strategy;

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
