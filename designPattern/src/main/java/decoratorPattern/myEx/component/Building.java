package decoratorPattern.myEx.component;

public abstract class Building {
  String description;

  public Building (String description) {
    this.description = description;
  }

  protected abstract Unit create (String unitName);

}
