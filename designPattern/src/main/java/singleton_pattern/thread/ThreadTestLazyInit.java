package singleton_pattern.thread;

import lombok.extern.slf4j.Slf4j;
import singleton_pattern.my_ex.ThisSingletonIsLazyInit_NotThreadSafe;

@Slf4j
public class ThreadTestLazyInit implements Runnable{

  @Override
  public void run () {
    ThisSingletonIsLazyInit_NotThreadSafe thisSingtonIsLazyInit_notThreadSafe = ThisSingletonIsLazyInit_NotThreadSafe.getInstance();
    log.info("== : {} ", String.valueOf(thisSingtonIsLazyInit_notThreadSafe == ThisSingletonIsLazyInit_NotThreadSafe.getInstance()));
    log.info("equals : {}", String.valueOf(thisSingtonIsLazyInit_notThreadSafe.equals(ThisSingletonIsLazyInit_NotThreadSafe.getInstance())));
  }
}
