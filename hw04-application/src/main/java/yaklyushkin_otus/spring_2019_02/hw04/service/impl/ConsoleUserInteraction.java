package yaklyushkin_otus.spring_2019_02.hw04.service.impl;

import yaklyushkin_otus.spring_2019_02.hw04.service.UserInteractionService;

import java.util.Scanner;

public class ConsoleUserInteraction implements UserInteractionService {

    @Override
    public String ask(String question) {
        if ((question != null) &&
             (question.trim().length() != 0)) {
            System.out.println(question);
        }

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void say(String text) {
        System.out.println(text);
    }
}
