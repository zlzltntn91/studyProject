package decoratorPattern.bookEx.bevarage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HouseBlend extends Bevarage {

  public HouseBlend () {
    super("하우스 블렌드");
  }

  @Override
  public int cost () {
    int cost = (int) Math.ceil(2300 * super.getSize().getRise());
    log.debug("HouseBlend cost : {}", cost);
    return cost;
  }
}
