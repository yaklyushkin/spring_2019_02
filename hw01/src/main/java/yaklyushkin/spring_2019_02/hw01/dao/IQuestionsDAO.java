package yaklyushkin.spring_2019_02.hw01.dao;

import yaklyushkin.spring_2019_02.hw01.domain.Question;
import yaklyushkin.spring_2019_02.hw01.exceptions.WrongDataException;

import java.util.List;

public interface IQuestionsDAO {
    List<Question> read() throws WrongDataException;
}
