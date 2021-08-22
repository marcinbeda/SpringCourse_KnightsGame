package pl.beda.springcourse_knightsgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringCourseKnightsGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCourseKnightsGameApplication.class, args);
    }
}
