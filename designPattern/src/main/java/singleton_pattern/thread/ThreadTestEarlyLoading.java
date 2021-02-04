package singleton_pattern.thread;

import lombok.extern.slf4j.Slf4j;
import singleton_pattern.my_ex.ThisSingletonIsEarlyLoading_ThreadSafe;

@Slf4j
public class ThreadTestEarlyLoading implements Runnable {

  @Override
  public void run () {
    ThisSingletonIsEarlyLoading_ThreadSafe mySingletonThreadSafe1 = ThisSingletonIsEarlyLoading_ThreadSafe.getInstance();
    log.info("== : {} ", String.valueOf(mySingletonThreadSafe1 == ThisSingletonIsEarlyLoading_ThreadSafe.getInstance()));
    log.info("equals : {}", String.valueOf(mySingletonThreadSafe1.equals(ThisSingletonIsEarlyLoading_ThreadSafe.getInstance())));
  }
}
