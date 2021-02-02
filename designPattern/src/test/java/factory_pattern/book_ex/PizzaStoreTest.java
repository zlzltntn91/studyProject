package factory_pattern.book_ex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PizzaStoreTest {

  @Before
  public void setUp () throws Exception {
  }

  @After
  public void tearDown () throws Exception {
  }

  @Test
  public void setPizzaStore(){
    PizzaStore nyPizza = new NyPizzaStore();
    assertThat(nyPizza, is(notNullValue()));
  }

  @Test
  public void orderPizza(){
    PizzaStore nyPizza = new NyPizzaStore();
    Pizza pizza = nyPizza.order(KindOf.치즈);
    assertThat(pizza, is(notNullValue()));
  }

  @Test
  public void orderNullPizza(){
    PizzaStore nyPizza = new NyPizzaStore();
    Pizza pizza = nyPizza.order(KindOf.페퍼로니);
    assertThat(pizza, is(nullValue()));
  }

  @Test
  public void orderCheesePizza(){
    PizzaStore nyPizza = new NyPizzaStore();
    Pizza pizza = nyPizza.order(KindOf.치즈);
    pizza.bake();
    assertThat(pizza, is(notNullValue()));
  }

  @Test
  public void setCustomPizza(){
    PizzaStore nyPizza = new NyPizzaStore();
    Pizza pizza = nyPizza.order(KindOf.치즈, "L");
    pizza.bake();
  }

}