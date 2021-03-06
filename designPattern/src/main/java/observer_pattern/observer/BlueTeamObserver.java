package observer_pattern.observer;

import lombok.extern.slf4j.Slf4j;
import observer_pattern.NotifyVo;

@Slf4j
public class BlueTeamObserver <T> implements Observer<T> {
  @Override
  public void update (T t) {
    if (t instanceof NotifyVo) {
      log.debug("BlueTeamObserver notify : {}", ((NotifyVo) t).getMessage());
    } else {
      log.debug("ERROR");
    }
  }
}
