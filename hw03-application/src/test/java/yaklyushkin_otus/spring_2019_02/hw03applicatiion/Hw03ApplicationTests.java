package yaklyushkin_otus.spring_2019_02.hw03applicatiion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import yaklyushkin.spring_2019_02.hw03.starter.Props;
import yaklyushkin_otus.spring_2019_02.hw03applicatiion.config.YamlProps;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class Hw03ApplicationTests {

    @Test
    public void contextLoads() {
        YamlProps exProps = ctx.getBean(YamlProps.class);
        assertEquals("russian", exProps.getLanguage());
        assertEquals("data/quiz_%s.csv", exProps.getFilePath());
        assertEquals(0, exProps.getQuestionsCount());

        Props props = ctx.getBean(Props.class);
        assertEquals("english", props.getLanguage());
        assertEquals(null, props.getFilePath());
        assertEquals(3, props.getQuestionsCount());
    }

    @Autowired
    private ApplicationContext ctx;
}
