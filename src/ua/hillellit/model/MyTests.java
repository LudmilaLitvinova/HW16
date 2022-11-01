package ua.hillellit.model;

/**
 * class with tests methods
 * @outhor Ludmila Litvinova
 */

public class MyTests {

  @Test(priority = 2)
  public void test1() {
    System.out.println("test1");
  }

  @Test(priority = 8)
  public void test2() {
    System.out.println("test2");
  }

  @Test()
  public void test3() {
    System.out.println("test3");
  }

  @BeforeSuite
  public void beforeSuite() {
    System.out.println("beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
    System.out.println("afterSuite");
  }
}
