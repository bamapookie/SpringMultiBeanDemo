package org.example.springmultibeandemo;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;

/**
 * Here is where the real magic is.  We are going to create a bean for each of the classes that we
 * want to be able to use generically.  We will use the properties from the application.properties
 * file to determine which classes we want to create beans for.
 */
@Configuration
@Log4j2
public class MultiBeanConfiguration {

  @Autowired
  MultiBeanConfiguration(final DefaultListableBeanFactory factory,
                         Application.ApplicationPropertyMap beans) {
    beans.getBeans().forEach((key, value) -> {
      try {
        log.info("Creating bean %s".formatted(key));
        final Class<?> genericClass = Class.forName(value.getGenericClass());
        createGenericBean(factory, key, value.getIndex(), genericClass);
      } catch (ClassNotFoundException e) {
        log.error("Error creating bean %s".formatted(key), e);
      }
    });
  }

  private <T> void createGenericBean(
      final DefaultListableBeanFactory factory,
      final String name,
      final String index,
      final Class<T> genericClass
  ) {
    final var bd = new RootBeanDefinition();
    bd.setTargetType(ResolvableType.forClassWithGenerics(GenericService.class, genericClass));
    bd.setAutowireCandidate(true);
    bd.setScope(BeanDefinition.SCOPE_SINGLETON);
    bd.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
    factory.registerBeanDefinition(name, bd);
    //apply BeanPostProcessors, autowire dependent beans if such exists, setPropertyValues
    final var instance =
        factory.configureBean(new GenericService<>(genericClass, index, name), name);
    //add bean to DefaultSingletonBeanRegistry registeredSingletons and singletonObjects
    factory.registerSingleton(name, instance);
  }

}
