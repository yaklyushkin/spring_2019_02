package yaklyushkin.spring_2019_02.hw03.service.impl;

import yaklyushkin.spring_2019_02.hw03.service.UserInteractionService;

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
