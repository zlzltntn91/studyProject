package singleton_pattern.my_ex;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThisSingletonIsLazyInit_NotThreadSafe {

  private static ThisSingletonIsLazyInit_NotThreadSafe uniqueInstance;
  public final String desc = "Lazy Init";

  private ThisSingletonIsLazyInit_NotThreadSafe () {}

  @SneakyThrows
  public static ThisSingletonIsLazyInit_NotThreadSafe getInstance () {
    if (uniqueInstance == null) {
      uniqueInstance = new ThisSingletonIsLazyInit_NotThreadSafe();
    }
    return uniqueInstance;
  }

}
