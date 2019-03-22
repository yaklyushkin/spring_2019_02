package yaklyushkin_otus.spring_2019_02.hw04application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import yaklyushkin_otus.spring_2019_02.hw04application.starter.QuizAutoConfiguration;
import yaklyushkin_otus.spring_2019_02.hw04application.starter.Props;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes=QuizAutoConfiguration.class)
public class QuizAutoConfigurationTests {

    @Test
    public void contextLoads() {
        Props props = ctx.getBean(Props.class);
        assertEquals("english", props.getLanguage());
        assertEquals("data/quiz_%s.csv", props.getFilePath());
        assertEquals(3, props.getQuestionsCount());
    }

    @Autowired
    private ApplicationContext ctx;
}
