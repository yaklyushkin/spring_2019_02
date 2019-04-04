package yaklyushkin_otus.spring_2019_02.hw05_app;

import org.springframework.boot.SpringApplication;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ApplicationTest {

    @Disabled
    @Test
    public void doTest() {
        Application application = new Application();
        application.test();
    }

    private static class Application {

        private void test() {
            SpringApplication.run(Hw05Configuration.class);
        }
    }
}
