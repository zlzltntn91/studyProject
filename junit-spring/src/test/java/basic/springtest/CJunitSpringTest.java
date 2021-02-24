package basic.springtest;

import kr.co.soo.junit_spring.bean.HelloBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/*.xml")
//@ContextConfiguration(locations = "file:src/main/context-*.xml")
//classpath: 현재 프로젝트가 실행 되었을 때 현재 classloader에 해당하는 경로의 리소스만 선택
//@ContextConfiguration(locations = "classpath:..xml")
//classpath*: 현재 프로젝트가 실행 되었을 때 현재 classloader의 경로 뿐만 아니라 상위 classloader를 모두 검색하여 해당 경로의 리소스를 선택
//@ContextConfiguration(locations = "classpath*:..xml")
public class CJunitSpringTest {

  @Autowired
  ApplicationContext applicationContext;

  @Autowired
  Environment environment;

  @Autowired
  HelloBean helloBean;

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
  public void getBeanByAutowired(){
    assertThat(helloBean, is(notNullValue()));
    assertThat(helloBean.getWithSetter(), is("dispatcherYesSetter"));
  }

  @Test
  public void getBean () {
    HelloBean helloBean = (HelloBean) applicationContext.getBean("helloBean");
    assertThat(helloBean, is(notNullValue()));
    assertThat(helloBean.getWithSetter(), is("dispatcherYesSetter"));
  }

}
