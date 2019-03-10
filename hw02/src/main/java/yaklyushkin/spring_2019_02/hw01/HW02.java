package yaklyushkin.spring_2019_02.hw01;

import yaklyushkin.spring_2019_02.hw01.service.MainRunner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HW02 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        MainRunner runner = ctx.getBean(MainRunner.class);
        runner.run();
    }
}
