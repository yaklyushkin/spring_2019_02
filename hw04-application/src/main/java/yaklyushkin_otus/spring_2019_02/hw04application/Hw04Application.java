package yaklyushkin_otus.spring_2019_02.hw04application;

import yaklyushkin_otus.spring_2019_02.hw04application.config.Hw04Configuration;

import org.springframework.boot.SpringApplication;

//@SpringBootApplication
// Запуск без Spring boot
public class Hw04Application {

    public static void main(String[] args) {
        SpringApplication.run(Hw04Configuration.class, args);
    }
}
