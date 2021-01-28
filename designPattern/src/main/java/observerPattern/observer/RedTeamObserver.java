package observerPattern.observer;

import lombok.extern.slf4j.Slf4j;
import observerPattern.NotifyVo;

@Slf4j
public class RedTeamObserver<T> implements Observer<T> {
  @Override
  public void update (T t) {
    if(t instanceof NotifyVo){
      log.debug("RedTeamObserver notify : {}", ((NotifyVo) t).getMessage());
    }else{
      log.debug("ERROR");
    }
  }
}
