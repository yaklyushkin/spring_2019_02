package yaklyushkin.spring_2019_02.hw04.service;

import yaklyushkin.spring_2019_02.hw04.domain.Person;

public interface QuizService {
    int quiz(Person person);

    int questionsCount();
}
