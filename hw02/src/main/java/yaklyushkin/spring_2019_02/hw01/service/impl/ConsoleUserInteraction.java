package yaklyushkin.spring_2019_02.hw01.service.impl;

import yaklyushkin.spring_2019_02.hw01.service.UserInteractionService;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
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
