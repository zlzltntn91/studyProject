package kr.co.soo.junit_spring.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

public class HelloBean {
  @Getter
  private String withoutSetter;

  @Setter
  @Getter
  private String withSetter;

}
