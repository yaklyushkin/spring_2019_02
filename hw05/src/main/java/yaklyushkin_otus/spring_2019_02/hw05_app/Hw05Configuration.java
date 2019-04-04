package yaklyushkin_otus.spring_2019_02.hw05_app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/*import org.springframework.shell.SpringShellAutoConfiguration;
import org.springframework.shell.jcommander.JCommanderParameterResolverAutoConfiguration;
import org.springframework.shell.jline.JLineShellAutoConfiguration;
import org.springframework.shell.standard.StandardAPIAutoConfiguration;
import org.springframework.shell.standard.commands.StandardCommandsAutoConfiguration;
*/
@Configuration
/*@Import({
        SpringShellAutoConfiguration.class,
        JLineShellAutoConfiguration.class,
        JCommanderParameterResolverAutoConfiguration.class,
        StandardAPIAutoConfiguration.class,
        StandardCommandsAutoConfiguration.class,
})*/
@ComponentScan(basePackages={
        //"yaklyushkin_otus.spring_2019_02.hw05_app.shell",
        "yaklyushkin_otus.spring_2019_02.hw05_app.repository",
        "yaklyushkin_otus.spring_2019_02.hw05_app.config"})
@EnableAutoConfiguration
public class Hw05Configuration {
}
