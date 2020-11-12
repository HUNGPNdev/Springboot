package btvn.lesson18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("btvn.lesson18.*")
public class Lesson18Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson18Application.class, args);
    }

}
