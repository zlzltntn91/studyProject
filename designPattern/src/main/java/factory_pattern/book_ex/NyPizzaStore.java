package factory_pattern.book_ex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NyPizzaStore extends PizzaStore {

  @Override
  Pizza order (KindOf pizza, String size) {
    switch (pizza) {
      case 치즈: return new NyCheesePizza(size);
      case 불고기: return new NyBullgogiPizza(size);
      default: log.error("{}은(는) {} 피자가 메뉴에 없습니다.", this.getClass().getSimpleName(), pizza);
        return null;
    }
  }
}
