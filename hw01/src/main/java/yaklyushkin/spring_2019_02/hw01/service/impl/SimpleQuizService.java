package yaklyushkin.spring_2019_02.hw01.service.impl;

import yaklyushkin.spring_2019_02.hw01.domain.Person;
import yaklyushkin.spring_2019_02.hw01.domain.Question;
import yaklyushkin.spring_2019_02.hw01.service.IQuestionsReadService;
import yaklyushkin.spring_2019_02.hw01.service.IQuizService;

import java.util.Scanner;

public class SimpleQuizService implements IQuizService {

    @Override
    public int quiz(Person person, IQuestionsReadService questions) {
        int result = 0;

        questions.start();
        int questionNum = 0;

        Scanner scanner = new Scanner(System.in);

        Question question = questions.next();
        while (question != null) {
                questionNum++;
                System.out.println(
                        String.format("Вопрос № %d: '%s'", questionNum, question.getQuestion()));
                String answer = scanner.nextLine();

                if (question.isAnswerCorrect(answer)) {
                    System.out.println("Верно");
                    result++;

                } else {
                    System.out.println("Ошибка");
                }

                question = questions.next();
            }

        return result;
    }
}
