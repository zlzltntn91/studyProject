package kr.co.soo.junit_spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "/")
@Slf4j
public class JunitTestController {

  @RequestMapping("")
  public String index(){
    log.debug("index");
    return "index";
  }

  @RequestMapping("test")
  public void test(){
    log.debug("test");
  }

}
