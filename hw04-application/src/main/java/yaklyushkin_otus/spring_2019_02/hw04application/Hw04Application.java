package yaklyushkin_otus.spring_2019_02.hw04application;

import yaklyushkin.spring_2019_02.hw04.runner.Runner;
import yaklyushkin_otus.spring_2019_02.hw04application.starter.QuizAutoConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Hw04Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(QuizAutoConfiguration.class, args);

        Runner runner = ctx.getBean(Runner.class);
        runner.run();
    }
}
