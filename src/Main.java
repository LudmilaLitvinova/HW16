import ua.hillellit.model.MyTests;
import ua.hillellit.model.TestRunner;

public class Main {

  public static void main(String[] args) {

    try {
      TestRunner.start(MyTests.class);
    } catch (IllegalAccessException | InstantiationException e) {
      throw new RuntimeException(e);
    }
  }
}