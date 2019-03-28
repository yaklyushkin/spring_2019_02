package yaklyushkin_otus.spring_2019_02.hw04application;

import yaklyushkin_otus.spring_2019_02.hw04application.config.Hw04Configuration;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;

@SpringBootTest(classes=Hw04Configuration.class,
        properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class Hw04ShellTests {

    @Disabled
    @Test
    public void contextLoads() {
        System.out.println(ctx);
        //System.out.println(shell);
        //shell.evaluate(() -> "quiz");
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(Hw04Configuration.class);
        Shell shell = ctx.getBean(Shell.class);
        System.out.println(shell);
        shell.evaluate(() -> "quiz");
    }

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private Shell shell;
}
