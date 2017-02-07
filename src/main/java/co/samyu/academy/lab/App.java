package co.samyu.academy.lab;

import co.samyu.academy.lab.domain.User;
import co.samyu.academy.lab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created on 02/Feb/2017.
 */

@EnableAutoConfiguration
@ComponentScan
@ConfigurationProperties
public class App implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        userRepository.save(new User());
    }
}
