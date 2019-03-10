package yaklyushkin.spring_2019_02.hw01.dao;

import yaklyushkin.spring_2019_02.hw01.consts.Consts;
import yaklyushkin.spring_2019_02.hw01.dao.impl.CSVQuestionsReader;
import yaklyushkin.spring_2019_02.hw01.exceptions.WrongDataException;

import org.junit.jupiter.api.Test;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

public class DAOTest {
    @Test
    public void CSVReaderTest() throws WrongDataException {
        CSVQuestionsReader reader = new CSVQuestionsReader(
                filePath, "russian", 5, new DummyMessageSource());
        reader.read();
    }

    private final String filePath =
            getClass().getClassLoader().getResource("data/questions_russian.csv").getFile();

    private static class DummyMessageSource implements MessageSource {

        @Override
        public String getMessage(String s, Object[] objects, String s1, Locale locale) {
            return null;
        }

        @Override
        public String getMessage(String s, Object[] objects, Locale locale) throws NoSuchMessageException {
            if (s.equals(Consts.MSG_CSV_READER_FILE_ERROR)) {
                return "MSG_CSV_READER_FILE_ERROR";
            } else {
                return "MSG_CSV_READER_PARSE_ERROR";
            }
        }

        @Override
        public String getMessage(MessageSourceResolvable messageSourceResolvable, Locale locale) throws NoSuchMessageException {
            return null;
        }
    }
}
