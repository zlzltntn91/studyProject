package junit;

import lombok.Getter;
import lombok.Setter;


public class User {

  @Setter
  @Getter
  private String id;

  @Setter
  @Getter
  private String name;

  @Setter
  @Getter
  private String email;

  @Getter
  private int age;
}
