package observerPattern;

import lombok.extern.slf4j.Slf4j;
import observerPattern.observer.BlueTeamObserver;
import observerPattern.observer.GreenTeamObserver;
import observerPattern.observer.RedTeamObserver;
import observerPattern.subject.ConcreteSubject;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class ConcreteSubjectTest {
  ConcreteSubject<NotifyVo> concreteSubject;

  @Before
  public void init () {
    concreteSubject = new ConcreteSubject<>();
    assertThat(concreteSubject, is(notNullValue()));
    notifyObserver();
  }

  @Test
  public void addObserver () {
    RedTeamObserver<NotifyVo> redTeamObserver = new RedTeamObserver<>();
    concreteSubject.addObserver(redTeamObserver);

    BlueTeamObserver<NotifyVo> blueTeamObserver = new BlueTeamObserver<>();
    concreteSubject.addObserver(blueTeamObserver);

    GreenTeamObserver<NotifyVo> greenTeamObjserver = new GreenTeamObserver<>();
    concreteSubject.addObserver(greenTeamObjserver);

    notifyObserver();
    concreteSubject.getObservers();
  }

  @Test
  public void removeObserver () {
    notifyObserver();
  }

  public void notifyObserver () {
    NotifyVo notifyVo = new NotifyVo();
    notifyVo.setMessage("Hello Observers");
    concreteSubject.notifyObserver(notifyVo);
  }

}
