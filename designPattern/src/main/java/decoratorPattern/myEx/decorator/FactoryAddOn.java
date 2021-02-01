package decoratorPattern.myEx.decorator;

import decoratorPattern.myEx.component.Building;
import decoratorPattern.myEx.component.Unit;

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
