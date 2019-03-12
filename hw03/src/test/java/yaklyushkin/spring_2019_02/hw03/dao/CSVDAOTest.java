package yaklyushkin.spring_2019_02.hw03.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import yaklyushkin.spring_2019_02.hw03.consts.Consts;
import yaklyushkin.spring_2019_02.hw03.dao.impl.CSVQuestionsReader;
import yaklyushkin.spring_2019_02.hw03.domain.Question;
import yaklyushkin.spring_2019_02.hw03.exceptions.WrongDataException;
import yaklyushkin.spring_2019_02.hw03.service.MessageService;
import yaklyushkin.spring_2019_02.hw03.service.impl.DefaultMessageServie;

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
