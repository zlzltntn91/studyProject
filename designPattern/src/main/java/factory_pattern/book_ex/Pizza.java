package factory_pattern.book_ex;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public abstract class Pizza {

  private String name;
  private String size;
  private String cost;
  private int time;

  void bake () {
    log.debug("굽는중입니다..");
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      log.error(e.getMessage());
    }
    complete();
  }

  void complete () {
    log.info("{}, {}, {}, {}", this.getName(), this.getCost(), this.getSize(), this.getTime());
    log.info("{}이/가 완성되었습니다.", this.getName());
  }
}
