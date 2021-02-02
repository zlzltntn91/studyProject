package decorator_pattern.bookEx.bevarage;

public class DarkRoast extends Bevarage {

  public DarkRoast () {
    super("다크 로스트");
  }

  @Override
  public int cost () {
    return (int) Math.ceil(2600 * getSize().getRise());
  }
}
