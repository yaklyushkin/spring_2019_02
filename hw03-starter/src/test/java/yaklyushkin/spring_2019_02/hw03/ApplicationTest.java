package yaklyushkin.spring_2019_02.hw03;

import yaklyushkin.spring_2019_02.hw03.starter.QuizAutoConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @Disabled
    @Test
    public void doTest() {
        Application application = new Application();
        application.test();
    }

    @SpringBootApplication
    private static class Application {

        private void test() {
            SpringApplication.run(QuizAutoConfiguration.class);
        }
    }
}
