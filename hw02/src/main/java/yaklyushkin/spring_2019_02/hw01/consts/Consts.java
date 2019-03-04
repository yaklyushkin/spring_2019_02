package yaklyushkin.spring_2019_02.hw01.consts;

import java.util.Locale;

public class Consts {

    public static String LANGUAGE_RUSSIAN = "russian";

    public static String LANGUAGE_ENGLISH = "english";

    public static String MSG_QUIZ_SERVICE_QUESTION = "quiz.service.question";

    public static String MSG_QUIZ_SERVICE_CORRECT = "quiz.service.correct";

    public static String MSG_QUIZ_SERVICE_ERROR = "quiz.service.error";

    public static String MSG_QUESTIONS_READ_ERROR = "questions.read.error";

    public static String MSG_RUNNER_RESULT = "runner.result";

    public static String MSG_PERSON_READER_SURNAME = "person.reader.surname";

    public static String MSG_PERSON_READER_NAME = "person.reader.name";

    public static String MSG_CSV_READER_FILE_ERROR = "csv.reader.file.error";

    public static String MSG_CSV_READER_PARSE_ERROR = "csv.reader.parse.error";

    public static Locale getLocale(String language) {
        Locale locale = null;
        if (language.equals(LANGUAGE_RUSSIAN)) {
            locale = new Locale("ru", "RU");
        } else if (language.equals(Consts.LANGUAGE_ENGLISH)) {
            locale = Locale.ENGLISH;
        }
        return locale;
    }
}
