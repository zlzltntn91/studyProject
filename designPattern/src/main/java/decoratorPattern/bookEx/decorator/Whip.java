package decoratorPattern.bookEx.decorator;

import decoratorPattern.bookEx.bevarage.Bevarage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class Whip extends Decorator{

  public Whip (Bevarage bevarage) {
    super.bevarage = bevarage;
    super.setSize(bevarage.getSize());
    super.setDescription("휘핑");
  }

  @Override
  public int cost () {
    int cost = (int)(300 * (bevarage.getSize().getRise()));
    log.debug("whip cost: {}", cost);
    return bevarage.cost() + cost;
  }

  @Override
  public String getDescription () {
    return StringUtils.join(bevarage.getDescription(), ", ", super.getDescription());
  }

}
