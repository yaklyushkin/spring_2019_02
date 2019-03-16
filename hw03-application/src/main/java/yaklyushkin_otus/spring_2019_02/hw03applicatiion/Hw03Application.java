package yaklyushkin_otus.spring_2019_02.hw03applicatiion;

import yaklyushkin.spring_2019_02.hw03.runner.Runner;

import yaklyushkin_otus.spring_2019_02.hw03applicatiion.config.ApplicationConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Hw03Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ApplicationConfig.class, args);

        Runner runner = ctx.getBean(Runner.class);
        runner.run();
    }
}
