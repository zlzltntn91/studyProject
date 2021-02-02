package observer_pattern.observer;

import lombok.extern.slf4j.Slf4j;
import observer_pattern.NotifyVo;

@Slf4j
public class GreenTeamObserver <T> implements Observer<T> {
  @Override
  public void update (T t) {
    if(t instanceof NotifyVo){
      log.debug("GreenTeamObserver notify : {}", ((NotifyVo) t).getMessage());
    }else{
      log.debug("ERROR");
    }
  }
}
