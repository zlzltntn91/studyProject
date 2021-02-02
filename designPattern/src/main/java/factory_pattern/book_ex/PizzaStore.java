package factory_pattern.book_ex;

public abstract class PizzaStore {
  public Pizza order(KindOf kindOf){
    return this.order(kindOf, "M");
  }
  abstract Pizza order(KindOf kindOf, String size);
}
