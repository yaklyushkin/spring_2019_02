package yaklyushkin_otus.spring_2019_02.hw04.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import yaklyushkin_otus.spring_2019_02.hw04.consts.Consts;
import yaklyushkin_otus.spring_2019_02.hw04.dao.impl.CSVQuestionsReader;
import yaklyushkin_otus.spring_2019_02.hw04.domain.Question;
import yaklyushkin_otus.spring_2019_02.hw04.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw04.service.MessageService;
import yaklyushkin_otus.spring_2019_02.hw04.service.impl.DefaultMessageServie;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CSVDAOTest {

    @Test
    public void CSVReaderTest() throws WrongDataException {
        QuestionsDAO reader = new CSVQuestionsReader(
                CSV_FILE_PATH,
                Consts.LANGUAGE_RUSSIAN,
                QUESTIONS_COUNT,
                MESSAGE_SERVICE);
        List<Question> quesionts = reader.read();

        assertEquals(QUESTIONS_COUNT, quesionts.size());

        assertEquals("вычислите 1 + 0", quesionts.get(2).getQuestion());

        assertEquals(true, quesionts.get(0).isAnswerCorrect("2"));
    }

    private static MessageService MESSAGE_SERVICE =
            new DefaultMessageServie(Consts.LANGUAGE_RUSSIAN);

    private static int QUESTIONS_COUNT = 5;

    private final String CSV_FILE_PATH =
            this.getClass().getClassLoader().getResource("data/questions_russian.csv").getFile();
}
