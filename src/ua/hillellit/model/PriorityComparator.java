package ua.hillellit.model;

import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * There is compare method which determines the priority of execution
 * @outhor Ludmila Litvinova
 */

public class PriorityComparator implements Comparator<Method> {

  @Override
  public int compare(Method o1, Method o2) {
    return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
  }
}
