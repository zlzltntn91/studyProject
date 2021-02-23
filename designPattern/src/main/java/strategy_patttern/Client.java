package strategy_patttern;

import lombok.extern.slf4j.Slf4j;
import strategy_patttern.context.Context;
import strategy_patttern.strategy.StrategyImpl2;
import strategy_patttern.strategy.StrategyImpl3;

/**
 * ─────────────────── 투팩 골리앗 드랍 ───────────────────
 * 투팩-아머리-스타포트-머신샵(1개만)-탱크-골리앗-스타포트 컨트롤타워 건설-드랍쉽 생산
 * ─────────────────── 원게이트 ───────────────────
 * 원게이트-어시밀레이터-사이버네틱스 코어-스타게이트
 */
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

