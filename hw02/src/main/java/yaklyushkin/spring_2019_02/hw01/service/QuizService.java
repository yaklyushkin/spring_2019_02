package yaklyushkin.spring_2019_02.hw01.service;

import yaklyushkin.spring_2019_02.hw01.domain.Person;

public interface QuizService {
    int quiz(Person person);

    int questionsCount();
}
