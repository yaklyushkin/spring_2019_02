package yaklyushkin.spring_2019_02.hw01.service;

import yaklyushkin.spring_2019_02.hw01.domain.Question;

public interface IQuestionsReadService {

    void start();

    Question next();

    int questionsCount();
}
