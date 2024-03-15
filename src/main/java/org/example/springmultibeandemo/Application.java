package org.example.springmultibeandemo;

import java.util.Map;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  /**
   * This creates a bean that will be populated with the "beans" property from the
   * application.properties file.
   */
  @Bean
  @ConfigurationProperties
  public ApplicationPropertyMap beans() {
    return new ApplicationPropertyMap();
  }

  /**
   * This gets the property map from the application.properties file.
   * <p/>
   * Since the Bean above has no prefix, and the property name below is "beans", the property map
   * will be populated with the "beans" property from the application.properties file.
   */
  @Data
  public static class ApplicationPropertyMap {
    private Map<String, ExampleProperties> beans;
  }

}
