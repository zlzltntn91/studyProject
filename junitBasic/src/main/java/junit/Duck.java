package junit;


public class Duck {

  private final String color;
  private final String name;

  public Duck (String color, String name) {

    if (color == null || "".equals(color)) {
      throw new IllegalArgumentException();
    }
    if (!"빨".equals(color)) {
      throw new IllegalArgumentException();
    }
    this.color = color;
    this.name = name;
  }

  public String sayMyName () {
    return name;
  }

  public String sayMyColor () {
    return color;
  }

  private String description(){
    return name + "은(는) 색상이 " + color + "이다.";
  }
}