package decoratorPattern.bookEx.bevarage;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Bevarage {

  private String description = "음료";
  private Size size = Size.TALL;

  public Bevarage (String description) {
    this.description = description;
  }

  public abstract int cost ();

  public enum Size {
    TALL(1), GRANDE(1.2), VENTI(1.4);
    double rise;

    Size (double rise) {
      this.rise = rise;
    }

    public double getRise () {
      return rise;
    }
  }

}


