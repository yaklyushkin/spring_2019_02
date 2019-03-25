package yaklyushkin_otus.spring_2019_02.hw04.runner.impl;

import yaklyushkin_otus.spring_2019_02.hw04.consts.Consts;
import yaklyushkin_otus.spring_2019_02.hw04.domain.Person;
import yaklyushkin_otus.spring_2019_02.hw04.runner.Runner;
import yaklyushkin_otus.spring_2019_02.hw04.service.MessageService;
import yaklyushkin_otus.spring_2019_02.hw04.service.PersonProvider;
import yaklyushkin_otus.spring_2019_02.hw04.service.QuizService;
import yaklyushkin_otus.spring_2019_02.hw04.service.UserInteractionService;

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
