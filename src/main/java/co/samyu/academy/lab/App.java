package co.samyu.academy.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created on 02/Feb/2017.
 */

@EnableAutoConfiguration
@ComponentScan
//@ConfigurationProperties(value = "application-${profile}.properties")
@ConfigurationProperties
public class App {
    public static void main(String[] args) {
        System.out.println(args);
        SpringApplication.run(App.class);
    }

}
