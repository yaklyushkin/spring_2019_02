package yaklyushkin_otus.spring_2019_02.hw05_app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import yaklyushkin_otus.spring_2019_02.hw05_app.config.Props;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes=Hw05Configuration.class)
public class DAOConfigurationTests {

    @Test
    public void contextLoads() {
        Props props = ctx.getBean(Props.class);
        assertEquals("english", props.getLanguage());
    }

    @Autowired
    private ApplicationContext ctx;
}
