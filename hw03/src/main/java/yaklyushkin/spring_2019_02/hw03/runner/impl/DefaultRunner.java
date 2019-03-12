package yaklyushkin.spring_2019_02.hw03.runner.impl;

import yaklyushkin.spring_2019_02.hw03.consts.Consts;
import yaklyushkin.spring_2019_02.hw03.domain.Person;
import yaklyushkin.spring_2019_02.hw03.runner.Runner;
import yaklyushkin.spring_2019_02.hw03.service.MessageService;
import yaklyushkin.spring_2019_02.hw03.service.PersonProvider;
import yaklyushkin.spring_2019_02.hw03.service.QuizService;
import yaklyushkin.spring_2019_02.hw03.service.UserInteractionService;

import java.util.Locale;

public class DefaultRunner implements Runner {

    public DefaultRunner(
            String language,
            MessageService messageSource,
            PersonProvider personProvider,
            QuizService quiz,
            UserInteractionService userInteraction) {
        this.personProvider = personProvider;
        this.quiz = quiz;
        this.userInteraction = userInteraction;

        Locale locale = Consts.getLocale(language);
        this.msgResult = messageSource.getMessage(
                Consts.MSG_RUNNER_RESULT, null, locale);
    }

    @Override
    public void run() {
        Person person = personProvider.get();
        userInteraction.say("");

        int correctAnswers = quiz.quiz(person);
        userInteraction.say("");

        userInteraction.say(
                String.format(this.msgResult,
                        correctAnswers, quiz.questionsCount()));
    }

    private final PersonProvider personProvider;

    private final QuizService quiz;

    private final UserInteractionService userInteraction;

    private final String msgResult;
}
