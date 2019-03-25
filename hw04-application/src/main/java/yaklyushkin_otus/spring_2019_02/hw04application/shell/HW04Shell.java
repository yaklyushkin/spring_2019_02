package yaklyushkin_otus.spring_2019_02.hw04application.shell;

import yaklyushkin_otus.spring_2019_02.hw04.runner.Runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class HW04Shell {

    public HW04Shell(@Autowired Runner runner) {
        this.runner = runner;
    }

    @ShellMethod("Run quiz.")
    public String quiz() {
        this.runner.run();
        return "Quiz ended.";
    }

    private final Runner runner;
}
