package yaklyushkin_otus.spring_2019_02.hw04application;

import org.springframework.context.ApplicationContext;
import yaklyushkin.spring_2019_02.hw04.runner.Runner;
import yaklyushkin_otus.spring_2019_02.hw04application.starter.QuizAutoConfiguration;

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
            ApplicationContext ctx = SpringApplication.run(QuizAutoConfiguration.class);
            /*Runner runner = ctx.getBean(Runner.class);
            runner.run();*/
        }
    }
}
