package basic;

import kr.co.soo.junit_spring.bean.HelloBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/*.xml")
public class JunitSpringTest {

  @Autowired
  ApplicationContext applicationContext;
  @Autowired
  Environment environment;

  @Test
  public void getApplicationContext () {
    assertThat(applicationContext, is(notNullValue()));
    log.info(applicationContext.getApplicationName());
  }

  @Test
  public void getContextInfo () {
    log.info(applicationContext.getApplicationName());
    log.info(applicationContext.getDisplayName());
    log.info(Arrays.toString(applicationContext.getEnvironment().getActiveProfiles()));
  }

  @Test
  public void getEnvironment () {
    log.info("Default Profiles : {}", Arrays.toString(environment.getDefaultProfiles()));
    log.info("Active Profiles : {}", Arrays.toString(environment.getActiveProfiles()));
  }

  @Test
  public void getBean () {
    HelloBean helloBean = (HelloBean) applicationContext.getBean("helloBean");
    assertThat(helloBean, is(notNullValue()));
    assertThat(helloBean.getWithSetter(), is("dispatcherYesSetter"));
  }

}
