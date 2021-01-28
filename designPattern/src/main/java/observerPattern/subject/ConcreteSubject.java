package observerPattern.subject;

import lombok.extern.slf4j.Slf4j;
import observerPattern.observer.Observer;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ConcreteSubject <T> implements Subject<T> {

  private final Set<Observer<T>> observers;

  public ConcreteSubject () {
    this.observers = new HashSet<>();
  }

  public boolean addObserver (Observer<T> observer) {
    log.debug(observer.toString());
    return this.observers.add(observer);
  }

  public void getObservers(){
    log.debug(observers.toString());
  }

  @Override
  public boolean removeObserver (Observer<T> observer) {
    return false;
  }

  @Override
  public void notifyObserver (T t) {
    observers.forEach(v -> v.update(t));
  }

}
