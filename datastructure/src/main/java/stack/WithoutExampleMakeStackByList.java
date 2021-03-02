package stack;

import java.util.ArrayList;
import java.util.List;

public class WithoutExampleMakeStackByList <T> {

  private final List<T> list;
  private int size;

  public WithoutExampleMakeStackByList () {
    list = new ArrayList<>();
  }

  public boolean push (T t) {
    size++;
    return list.add(t);
  }

  public T pop () {
    size--;
    T result = list.get(list.size() - 1);
    list.remove(list.size() - 1);
    return result;
  }

  public int getSize () {
    return size;
  }

}
