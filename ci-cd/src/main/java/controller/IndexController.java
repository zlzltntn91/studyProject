package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/jenkins")
public class IndexController {

  public ModelAndView helloJenkins(){
    ModelAndView mv = new ModelAndView();
    mv.addObject("message", "Hello Jenkins");
    return mv;
  }
}
