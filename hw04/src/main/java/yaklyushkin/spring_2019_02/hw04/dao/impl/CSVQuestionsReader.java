package yaklyushkin.spring_2019_02.hw04.dao.impl;

import yaklyushkin.spring_2019_02.hw04.consts.Consts;
import yaklyushkin.spring_2019_02.hw04.dao.QuestionsDAO;
import yaklyushkin.spring_2019_02.hw04.domain.Question;
import yaklyushkin.spring_2019_02.hw04.exceptions.WrongDataException;
import yaklyushkin.spring_2019_02.hw04.service.MessageService;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class CSVQuestionsReader implements QuestionsDAO {

    public CSVQuestionsReader(
            String filePath,
            String language,
            int questionsCount,
            MessageService messageSource) {
        this.filePath = filePath;
        this.questionsCount = questionsCount;

        Locale locale = Consts.getLocale(language);
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
            Reader in = new InputStreamReader(
                    new FileInputStream(filePath), StandardCharsets.UTF_8);
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

        return Collections.unmodifiableList(result);
    }

    private final String filePath;

    private final int questionsCount;

    private final String msgFileErr;
    private final String msgParseErr;

    private List<Question> questions;
}
