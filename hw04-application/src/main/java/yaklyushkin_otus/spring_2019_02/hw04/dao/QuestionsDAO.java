package yaklyushkin_otus.spring_2019_02.hw04.dao;

import yaklyushkin_otus.spring_2019_02.hw04.domain.Question;
import yaklyushkin_otus.spring_2019_02.hw04.exceptions.WrongDataException;

import java.util.List;

public interface QuestionsDAO {
    List<Question> read() throws WrongDataException;
}
