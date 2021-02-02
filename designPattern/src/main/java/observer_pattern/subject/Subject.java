package observer_pattern.subject;

import observer_pattern.observer.Observer;

public interface Subject <T>  {

  boolean  addObserver (Observer<T> observer);

  boolean removeObserver (Observer<T> observer);

  void notifyObserver (T t);
}
