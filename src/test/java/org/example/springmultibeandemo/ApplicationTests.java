package org.example.springmultibeandemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

  @Autowired
  private Controller controller;

  @Test
  void contextLoads() {
    assertTrue(true);
  }

  @Test
  void exampleOneExistsAndWasAutowiredToTheController() {
    assertEquals(
        "GenericClass{ clazz='class java.lang.String', index='example-one', name='exampleone', parameter='ExampleOne'}",
        controller.getExampleOne());
  }

  @Test
  void exampleTwoExistsAndWasAutowiredToTheController() {
    assertEquals(
        "GenericClass{ clazz='class java.lang.Integer', index='example-two', name='exampletwo', parameter='2'}",
        controller.getExampleTwo());
  }

}
