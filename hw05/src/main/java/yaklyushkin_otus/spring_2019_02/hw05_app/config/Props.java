package yaklyushkin_otus.spring_2019_02.hw05_app.config;

import yaklyushkin_otus.spring_2019_02.hw05.consts.StringConsts;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="hw05")
public class Props {

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String language = StringConsts.LANGUAGE_RUSSIAN;
}
