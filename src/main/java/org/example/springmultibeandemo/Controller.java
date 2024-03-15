package org.example.springmultibeandemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class Controller {

  private final GenericService<String> randomStringServiceName;

  private final GenericService<Integer> theIntegerServiceIsLookedUpByTheTypeAndGenericType;

  @Lazy
  @Autowired
  public Controller(GenericService<String> randomStringServiceName, GenericService<Integer> theIntegerServiceIsLookedUpByTheTypeAndGenericType) {
    this.randomStringServiceName = randomStringServiceName;
    this.theIntegerServiceIsLookedUpByTheTypeAndGenericType =
        theIntegerServiceIsLookedUpByTheTypeAndGenericType;
  }

  public String getExampleOne() {
        return randomStringServiceName.output("ExampleOne");
    }

    public String getExampleTwo() {
        return theIntegerServiceIsLookedUpByTheTypeAndGenericType.output(2);
    }
}
