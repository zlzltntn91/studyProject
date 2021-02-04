package singleton_pattern.my_ex;

public class ThisSingletonIsEarlyLoading_ThreadSafe {

  String desc = "Early loading";

  private static final ThisSingletonIsEarlyLoading_ThreadSafe MY_SINGLETON_THREAD_SAFE_1NNOTTHREADSAFE1 = new ThisSingletonIsEarlyLoading_ThreadSafe();

  private ThisSingletonIsEarlyLoading_ThreadSafe () {}

  public static ThisSingletonIsEarlyLoading_ThreadSafe getInstance () {
    return MY_SINGLETON_THREAD_SAFE_1NNOTTHREADSAFE1;
  }
}
