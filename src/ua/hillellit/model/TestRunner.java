package ua.hillellit.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Class use for run methods from test class
 *
 * @outhor Ludmila Litvinova
 */

public class TestRunner {

  public static void start(Class clazz) throws IllegalAccessException, InstantiationException {
    runMethod(clazz, BeforeSuite.class);
    runMethod(clazz, Test.class);
    runMethod(clazz, AfterSuite.class);
  }

  private static void runMethod(Class clazz, Class<? extends Annotation> annotationClass)
      throws IllegalAccessException, InstantiationException {
    Method[] methods = clazz.getMethods();
    Object t = clazz.newInstance();

    checkSuiteAnnotations(methods, annotationClass);

    Arrays.stream(methods)
        .filter(method -> method.isAnnotationPresent(annotationClass))
        .sorted(new PriorityComparator())
        .forEach(m -> {
          try {
            m.invoke(t);
          } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
          }
        });
  }

  private static void checkSuiteAnnotations(Method[] methods,
      Class<? extends Annotation> annotationClass) {
    long count = Arrays.stream(methods)
        .filter(method -> method.isAnnotationPresent(annotationClass)).count();
    if (count > 1 && (annotationClass.equals(AfterSuite.class) || annotationClass.equals(
        BeforeSuite.class))) {
      throw new RuntimeException("Multiple suite annotation");
    }
  }
}
