package co.samyu.academy.lab;

import co.samyu.academy.lab.domain.Authority;
import co.samyu.academy.lab.domain.User;
import co.samyu.academy.lab.repository.AuthorityRepository;
import co.samyu.academy.lab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ImageBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 02/Feb/2017.
 */

@EnableAutoConfiguration
@ComponentScan
@ConfigurationProperties
public class App implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... strings) throws Exception {

        //authorityRepository.deleteAll();
        //userRepository.deleteAll();

        Authority auth1 = new Authority("ROLE_ADMIN");
        Authority auth2 = new Authority("ROLE_USER");

        Set<Authority> authoritySet = new HashSet<>();

        authoritySet.add(authorityRepository.save(auth1));
        authoritySet.add(authorityRepository.save(auth2));

        //3;admin;$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC;Administrator;Administrator;admin@localhost;true;en;system;SQ;SIN;MOC;2015-05-12 00:00:00
        User user = new User();
        user.setLogin("admin");
        user.setPassword("$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC");
        user.setFirstName("Administrator");
        user.setLastName("Administrator");
        user.setEmail("admin@localhost");
        user.setActivated(true);
        user.setLangKey("en");
        user.setCreatedBy("system");
        user.setCreatedDate(ZonedDateTime.now());
        user.setUpdatedBy("system");
        user.setUpdatedDate(ZonedDateTime.now());
        user.setAuthorities(authoritySet);
        userRepository.save(user);

    }
}
