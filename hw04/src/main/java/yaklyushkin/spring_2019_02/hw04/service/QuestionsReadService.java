package yaklyushkin.spring_2019_02.hw04.service;

import yaklyushkin.spring_2019_02.hw04.domain.Question;

public interface QuestionsReadService {

    void start();

    Question next();

    int questionsCount();
}
