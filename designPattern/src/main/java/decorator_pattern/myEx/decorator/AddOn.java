package decorator_pattern.myEx.decorator;

import decorator_pattern.myEx.component.Building;

public abstract class AddOn extends Building {

  public AddOn (String description) {
    super(description);
  }

}
