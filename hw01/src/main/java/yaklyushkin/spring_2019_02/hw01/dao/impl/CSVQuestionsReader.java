package yaklyushkin.spring_2019_02.hw01.dao.impl;

import static yaklyushkin.spring_2019_02.hw01.consts.Consts.questionsCount;

import yaklyushkin.spring_2019_02.hw01.dao.IQuestionsDAO;
import yaklyushkin.spring_2019_02.hw01.domain.Question;
import yaklyushkin.spring_2019_02.hw01.exceptions.WrongDataException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVQuestionsReader implements IQuestionsDAO {

    public CSVQuestionsReader(String filePath) {
        this._filePath = filePath;
    }

    public List<Question> read() throws WrongDataException {
        if (this._questions == null) {
            this._questions = _readQuestions(this._filePath);
        }
        return _questions;
    }

    private static List<Question> _readQuestions(String filePath) throws WrongDataException {
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
            throw new WrongDataException("Не найден CSV-файл!");
        } catch (IOException exception) {
            throw new WrongDataException(
                    String.format("Ошибка обработки CSV-файла: '%s'!", exception.getMessage()));
        }

        return result;
    }

    private final String _filePath;

    private List<Question> _questions;
}
