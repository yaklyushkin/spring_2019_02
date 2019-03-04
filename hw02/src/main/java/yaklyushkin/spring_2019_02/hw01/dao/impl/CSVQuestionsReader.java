package yaklyushkin.spring_2019_02.hw01.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import yaklyushkin.spring_2019_02.hw01.consts.Consts;
import yaklyushkin.spring_2019_02.hw01.dao.QuestionsDAO;
import yaklyushkin.spring_2019_02.hw01.domain.Question;
import yaklyushkin.spring_2019_02.hw01.exceptions.WrongDataException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CSVQuestionsReader implements QuestionsDAO {

    @Value("${questions.count}")
    private int questionsCount;

    public CSVQuestionsReader(String filePath) {
        this.filePath = filePath;
    }

    @PostConstruct
    public void init() {
        Locale locale = Consts.getLocale(this.language);
        this.msgFileErr= messageSource.getMessage(
                Consts.MSG_CSV_READER_FILE_ERROR, null, locale);
        this.msgParseErr = messageSource.getMessage(
                Consts.MSG_CSV_READER_PARSE_ERROR, null, locale);
    }

    public List<Question> read() throws WrongDataException {
        if (this.questions == null) {
            this.questions = readQuestions(this.filePath);
        }
        return questions;
    }

    private List<Question> readQuestions(String filePath) throws WrongDataException {
        List<Question> result = new ArrayList<>(questionsCount);

        try {
            Reader in = new FileReader(filePath);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
            for (CSVRecord record : records) {
                String question = record.get(0);
                String answer = record.get(1);
                result.add(new Question(question, answer));
            }
        } catch (FileNotFoundException exception) {
            throw new WrongDataException(this.msgFileErr);
        } catch (IOException exception) {
            throw new WrongDataException(String.format(this.msgParseErr, exception.getMessage()));
        }

        return result;
    }

    private final String filePath;

    private List<Question> questions;

    @Value("${common.language}")
    private String language;

    @Autowired
    private MessageSource messageSource;

    private String msgFileErr;
    private String msgParseErr;

}
