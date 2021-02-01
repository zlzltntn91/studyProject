package decoratorPattern.myEx.component;

public class Factory extends Building{

  public Factory () {
    super("팩토리");
  }

  @Override
  protected Unit create (String unitName) {
    return null;
  }
}
