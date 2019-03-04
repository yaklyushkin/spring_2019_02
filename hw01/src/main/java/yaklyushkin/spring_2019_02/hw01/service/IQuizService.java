package yaklyushkin.spring_2019_02.hw01.service;

import yaklyushkin.spring_2019_02.hw01.domain.Person;

public interface IQuizService {
    int quiz(Person person, IQuestionsReadService questions);
}
