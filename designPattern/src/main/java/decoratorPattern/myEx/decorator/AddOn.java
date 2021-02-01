package decoratorPattern.myEx.decorator;

import decoratorPattern.myEx.component.Building;

public abstract class AddOn extends Building {

  public AddOn (String description) {
    super(description);
  }

}
