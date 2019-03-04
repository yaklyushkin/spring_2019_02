package yaklyushkin.spring_2019_02.hw01.domain;

import yaklyushkin.spring_2019_02.hw01.exceptions.WrongDataException;

public class Question {

    public Question(String question, String answer) throws WrongDataException {
        if ((question == null) ||
            (question.trim().length() == 0)) {
            throw new WrongDataException("Задан пустой вопрос!");
        }
        if ((answer == null) ||
            (answer .trim().length() == 0)) {
            throw new WrongDataException("Задан пустой ответ!");
        }
        this._question = question.trim();
        this._answer = answer.trim();
    }

    public String getQuestion() {
        return this._question;
    }

    public boolean isAnswerCorrect(String answer) {
        return (this._answer.equals(answer.trim()));
    }

    private final String _question;

    private final String _answer;
}
