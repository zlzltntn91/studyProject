package decorator_pattern.myEx.decorator;

import decorator_pattern.myEx.component.Building;
import decorator_pattern.myEx.component.Unit;

public class FactoryAddOn extends AddOn {

  Building building;

  public FactoryAddOn (String description) {
    super(description);
  }

  @Override
  protected Unit create (String unitName) {
    return null;
  }

}
