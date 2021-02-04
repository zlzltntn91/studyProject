package singleton_pattern.my_ex;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import singleton_pattern.thread.ThreadTestEarlyLoading;
import singleton_pattern.thread.ThreadTestLazyInit;

@Slf4j
public class MySingletonNotThreadSafeTest {

  @SneakyThrows
  public static void main (String[] args) {
    Runnable runnable = new ThreadTestEarlyLoading();
    Thread thread = new Thread(runnable);
    Thread thread2 = new Thread(runnable);
    thread.start();
    thread2.start();
    Thread.sleep(3000);
    Runnable runnable1 = new ThreadTestLazyInit();
    Thread thread3 = new Thread(runnable1);
    Thread thread4 = new Thread(runnable1);
    thread3.start();
    thread4.start();
  }
}
