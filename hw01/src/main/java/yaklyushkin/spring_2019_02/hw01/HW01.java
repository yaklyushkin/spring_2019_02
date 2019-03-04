package yaklyushkin.spring_2019_02.hw01;

import yaklyushkin.spring_2019_02.hw01.domain.Person;
import yaklyushkin.spring_2019_02.hw01.service.IPersonProvider;
import yaklyushkin.spring_2019_02.hw01.service.IQuestionsReadService;
import yaklyushkin.spring_2019_02.hw01.service.IQuizService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HW01 {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-context.xml");

        IPersonProvider personProvider = ctx.getBean(IPersonProvider.class);
        Person person = personProvider.get();

        IQuestionsReadService questionsService = ctx.getBean(IQuestionsReadService.class);

        IQuizService quiz = ctx.getBean(IQuizService.class);
        System.out.println();
        int correctAnswers = quiz.quiz(person, questionsService);
        System.out.println();

        System.out.println(
                String.format("Вы ответили на %d вопрос. из %d",
                        correctAnswers, questionsService.questionsCount()));
    }
}
