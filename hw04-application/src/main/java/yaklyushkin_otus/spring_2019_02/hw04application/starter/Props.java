package yaklyushkin_otus.spring_2019_02.hw04application.starter;

import yaklyushkin_otus.spring_2019_02.hw04.consts.Consts;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="hw04")
public class Props {

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getQuestionsCount() {
        return questionsCount;
    }

    public void setQuestionsCount(int questionsCount) {
        this.questionsCount = questionsCount;
    }

    private String language = Consts.LANGUAGE_RUSSIAN;

    private String filePath = "data/questions_%s.csv";

    private int questionsCount = 5;
}
