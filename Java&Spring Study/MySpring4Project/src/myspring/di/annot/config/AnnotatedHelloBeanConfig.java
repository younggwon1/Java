package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"myspring.di.annot"}) //<context:component-scan base-package="myspring.di.annot" />¿Í µ¿ÀÏ
@PropertySource("classpath:config/values.properties")
public class AnnotatedHelloBeanConfig {

}
