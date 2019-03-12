package yaklyushkin.spring_2019_02.hw03.dao;

import yaklyushkin.spring_2019_02.hw03.domain.Question;
import yaklyushkin.spring_2019_02.hw03.exceptions.WrongDataException;

import java.util.List;

public interface QuestionsDAO {
    List<Question> read() throws WrongDataException;
}
