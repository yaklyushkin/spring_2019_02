package yaklyushkin.spring_2019_02.hw01.service.impl;

import yaklyushkin.spring_2019_02.hw01.consts.Consts;
import yaklyushkin.spring_2019_02.hw01.domain.Person;
import yaklyushkin.spring_2019_02.hw01.service.MainRunner;
import yaklyushkin.spring_2019_02.hw01.service.PersonProvider;
import yaklyushkin.spring_2019_02.hw01.service.QuizService;
import yaklyushkin.spring_2019_02.hw01.service.UserInteractionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.Locale;

@Service
public class MainRunnerImpl implements MainRunner {

    @Autowired
    public MainRunnerImpl(PersonProvider personProvider,
                          QuizService quiz,
                          UserInteractionService userInteraction) {
        this.personProvider = personProvider;
        this.quiz = quiz;
        this.userInteraction = userInteraction;
    }

    @PostConstruct
    public void init() {
        Locale locale = Consts.getLocale(this.language);
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

    @Value("${common.language}")
    private String language;

    @Autowired
    private MessageSource messageSource;

    private String msgResult;
}
