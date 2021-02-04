package singleton_pattern.my_ex;

public class ThisSingletonIsLazyInit_ThreadSafe {

  private final String desc = "늦은 초기화 쓰레드 세이프 싱글톤";

  private ThisSingletonIsLazyInit_ThreadSafe () {
  }

  private static ThisSingletonIsLazyInit_ThreadSafe thisSingletonIsLazyInit_threadSafe;

  public static synchronized ThisSingletonIsLazyInit_ThreadSafe getInstance(){
    if(thisSingletonIsLazyInit_threadSafe == null){
      thisSingletonIsLazyInit_threadSafe = new ThisSingletonIsLazyInit_ThreadSafe();
    }
    return thisSingletonIsLazyInit_threadSafe;
  } 
}
