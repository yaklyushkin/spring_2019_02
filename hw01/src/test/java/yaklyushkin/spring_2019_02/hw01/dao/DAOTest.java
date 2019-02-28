package yaklyushkin.spring_2019_02.hw01.dao;

import yaklyushkin.spring_2019_02.hw01.dao.impl.CSVQuestionsReader;
import yaklyushkin.spring_2019_02.hw01.exceptions.WrongDataException;

import org.junit.Test;

public class DAOTest {
    @Test
    public void CSVReaderTest() throws WrongDataException {
        CSVQuestionsReader reader = new CSVQuestionsReader(_filePath);
        reader.read();
    }

    private final String _filePath =
            getClass().getClassLoader().getResource("data/questions.csv").getFile();
}
