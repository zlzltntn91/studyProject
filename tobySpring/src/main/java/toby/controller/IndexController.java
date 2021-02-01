package toby.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

  @RequestMapping(value = "/home")
  public void helloSpring () {
    log.debug("Hello Spring");
    log.debug("go to home.jsp");
  }
}
