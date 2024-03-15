package org.example.springmultibeandemo;

public class GenericService<T> {
  private final Class<T> clazz;
  private final String index;
  private final String name;

  public GenericService(Class<T> clazz, String index, String name) {
    this.clazz = clazz;
    this.index = index;
    this.name = name;
  }

  public String output(T t) {
    return "GenericClass{ clazz='%s', index='%s', name='%s', parameter='%s'}"
        .formatted(clazz, index, name, t);

  }
}
