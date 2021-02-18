package decorator_Pattern.bookEx.bevarage;

import decorator_pattern.bookEx.bevarage.Bevarage;
import decorator_pattern.bookEx.bevarage.DarkRoast;
import decorator_pattern.bookEx.bevarage.HouseBlend;
import decorator_pattern.bookEx.decorator.Whip;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class BevarageTest {


  @Test(expected = IllegalArgumentException.class)
  public void checkEnumByGall () {
    Bevarage.Size.valueOf("GALL");
  }

  @Test
  public void checkEnumByVenti () {
    Bevarage.Size size = Bevarage.Size.valueOf("VENTI");
    assertThat(size, is(notNullValue()));
    assertThat(size, is(instanceOf(Bevarage.Size.class)));
    assertThat(size, is(Bevarage.Size.VENTI));
    log.debug("Bevarage.Size : {} ", size);

  }

  @Test
  public void houseBlendTest () {
    Bevarage bevarage = new HouseBlend();
    log.debug("이름: {}, 사이즈 : {}, 가격 : {}", bevarage.getDescription(), bevarage.getSize(), bevarage.cost());
  }

  @Test
  public void darKRoastTest () {
    Bevarage bevarage = new DarkRoast();
    log.debug("이름: {}, 사이즈 : {}, 가격 : {}", bevarage.getDescription(), bevarage.getSize(), bevarage.cost());
  }

  @Test
  public void setSizeTest () {
    List<Bevarage> customerList = new ArrayList<>();
    customerList.add(new DarkRoast());
    customerList.add(new HouseBlend());

    for (Bevarage bv : customerList) {
      bv.setSize(Bevarage.Size.GRANDE);
      log.debug("이름: {}, 사이즈 : {}, 가격 : {}", bv.getDescription(), bv.getSize(), bv.cost());
    }
  }

  @Test
  public void decoratorTest () {
    Bevarage bevarage = new HouseBlend();
    bevarage.setSize(Bevarage.Size.GRANDE);
    bevarage = new Whip(bevarage);
    bevarage = new Whip(bevarage);
    bevarage = new Whip(bevarage);

    log.debug("size: {}", bevarage.getSize());
    log.debug(bevarage.getDescription());
    log.debug("cost : {}", bevarage.cost());
  }
}