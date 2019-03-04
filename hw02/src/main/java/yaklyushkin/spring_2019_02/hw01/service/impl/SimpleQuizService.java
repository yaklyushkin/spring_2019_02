package yaklyushkin.spring_2019_02.hw01.service.impl;

import yaklyushkin.spring_2019_02.hw01.consts.Consts;
import yaklyushkin.spring_2019_02.hw01.domain.Person;
import yaklyushkin.spring_2019_02.hw01.domain.Question;
import yaklyushkin.spring_2019_02.hw01.service.QuestionsReadService;
import yaklyushkin.spring_2019_02.hw01.service.QuizService;
import yaklyushkin.spring_2019_02.hw01.service.UserInteractionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.Locale;

@Service
public class SimpleQuizService implements QuizService {

    @Autowired
    public SimpleQuizService(QuestionsReadService questions,
                             UserInteractionService userInteraction) {
        this.questions = questions;
        this.userInteraction = userInteraction;
    }

    @PostConstruct
    public void init() {
        Locale locale = Consts.getLocale(this.language);
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

    @Value("${common.language}")
    private String language;

    @Autowired
    private MessageSource messageSource;

    private String msgQuestion;
    private String msgError;
    private String msgCorrect;
}
