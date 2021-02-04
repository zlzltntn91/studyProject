package templatemethod_pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Bevarage {

  public final void makeBevarage(){
    boil();
    brew();
    pour();
    addCondiments();
  }

  protected abstract void brew();

  private void boil(){
    log.info("물을 끓입니다.");
  }

  private void pour(){
    log.info("컵에 붓습니다.");
  }

  protected void addCondiments(){

  }
}
