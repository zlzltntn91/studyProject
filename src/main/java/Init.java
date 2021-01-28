import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Init {
  public void initTest(){
    log.debug("hi");
  }

  public static void main (String[] args) {
    Init t = new Init();
    t.initTest();
  }
}
