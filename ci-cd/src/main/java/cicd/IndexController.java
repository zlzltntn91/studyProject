package cicd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

  @RequestMapping("jenkins")
  public ModelAndView index(){
    ModelAndView mav = new ModelAndView();
    mav.addObject("message", "'Hello Jenkins!'");
    mav.setViewName("jenkins");
    return mav;
  }
  
}
