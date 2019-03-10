package yaklyushkin.spring_2019_02.hw01.service;

import yaklyushkin.spring_2019_02.hw01.domain.Question;

public interface QuestionsReadService {

    void start();

    Question next();

    int questionsCount();
}
