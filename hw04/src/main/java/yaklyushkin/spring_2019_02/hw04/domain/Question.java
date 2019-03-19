package yaklyushkin.spring_2019_02.hw04.domain;

import yaklyushkin.spring_2019_02.hw04.exceptions.WrongDataException;

import org.apache.commons.lang3.StringUtils;

public class Question {

    public Question(String question, String answer) throws WrongDataException {
        if (StringUtils.isBlank(question)) {
            throw new WrongDataException("Задан пустой вопрос!");
        }
        if (StringUtils.isBlank(answer)) {
            throw new WrongDataException("Задан пустой ответ!");
        }
        this.question = question.trim();
        this.answer = answer.trim();
    }

    public String getQuestion() {
        return this.question;
    }

    public boolean isAnswerCorrect(String answer) {
        return (this.answer.equals(answer.trim()));
    }

    private final String question;

    private final String answer;
}
