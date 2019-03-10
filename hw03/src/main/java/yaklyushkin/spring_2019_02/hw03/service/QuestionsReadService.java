package yaklyushkin.spring_2019_02.hw03.service;

import yaklyushkin.spring_2019_02.hw03.domain.Question;

public interface QuestionsReadService {

    void start();

    Question next();

    int questionsCount();
}
