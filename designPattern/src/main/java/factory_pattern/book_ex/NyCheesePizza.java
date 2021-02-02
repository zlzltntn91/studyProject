package factory_pattern.book_ex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NyCheesePizza extends Pizza {

  public NyCheesePizza(String size){
    super.setName("뉴욕치즈피자");
    super.setSize(size);
    super.setTime(5000);
    super.setCost("8000");
  }
}
