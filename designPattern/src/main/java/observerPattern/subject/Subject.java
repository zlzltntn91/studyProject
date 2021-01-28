package observerPattern.subject;

import observerPattern.observer.Observer;

public interface Subject <T>  {

  boolean  addObserver (Observer<T> observer);

  boolean removeObserver (Observer<T> observer);

  void notifyObserver (T t);
}
