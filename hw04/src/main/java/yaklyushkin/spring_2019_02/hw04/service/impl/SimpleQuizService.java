package yaklyushkin.spring_2019_02.hw04.service.impl;

import yaklyushkin.spring_2019_02.hw04.consts.Consts;
import yaklyushkin.spring_2019_02.hw04.domain.Person;
import yaklyushkin.spring_2019_02.hw04.domain.Question;
import yaklyushkin.spring_2019_02.hw04.service.MessageService;
import yaklyushkin.spring_2019_02.hw04.service.QuestionsReadService;
import yaklyushkin.spring_2019_02.hw04.service.QuizService;
import yaklyushkin.spring_2019_02.hw04.service.UserInteractionService;

import java.util.Locale;

public class SimpleQuizService implements QuizService {

    public SimpleQuizService(
            String language,
            MessageService messageSource,
            QuestionsReadService questions,
            UserInteractionService userInteraction) {
        this.questions = questions;
        this.userInteraction = userInteraction;

        Locale locale = Consts.getLocale(language);
        this.msgQuestion = messageSource.getMessage(
                Consts.MSG_QUIZ_SERVICE_QUESTION, null, locale);
        this.msgCorrect = messageSource.getMessage(
                Consts.MSG_QUIZ_SERVICE_CORRECT, null, locale);
        this.msgError = messageSource.getMessage(
                Consts.MSG_QUIZ_SERVICE_ERROR, null, locale);
    }

    @Override
    public int quiz(Person person) {
        int result = 0;

        int questionNum = 0;
        questions.start();

        Question question = questions.next();
        while (question != null) {
                questionNum++;
                String answer = userInteraction.ask(
                        String.format(this.msgQuestion, questionNum, question.getQuestion()));

                if (question.isAnswerCorrect(answer)) {
                    userInteraction.say(this.msgCorrect);
                    result++;

                } else {
                    userInteraction.say(this.msgError);
                }

                question = questions.next();
            }

        return result;
    }

    @Override
    public int questionsCount() {
        return this.questions.questionsCount();
    }

    private final QuestionsReadService questions;

    private final UserInteractionService userInteraction;

    private final String msgQuestion;
    private final String msgError;
    private final String msgCorrect;
}
