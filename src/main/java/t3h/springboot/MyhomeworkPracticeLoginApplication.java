package t3h.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("t3h.springboot.*")
public class MyhomeworkPracticeLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyhomeworkPracticeLoginApplication.class, args);
    }

}
