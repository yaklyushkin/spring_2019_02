package yaklyushkin.spring_2019_02.hw01.service.impl;

import yaklyushkin.spring_2019_02.hw01.dao.IQuestionsDAO;
import yaklyushkin.spring_2019_02.hw01.domain.Question;
import yaklyushkin.spring_2019_02.hw01.exceptions.WrongDataException;
import yaklyushkin.spring_2019_02.hw01.service.IQuestionsReadService;

import java.util.List;

public class SimpleQuestionsReadService implements IQuestionsReadService {

    public SimpleQuestionsReadService(IQuestionsDAO dao) throws WrongDataException {
        this._questions = dao.read();
        if (this._questions == null) {
            throw new WrongDataException("Получен пустой список вопросов!");
        }
    }

    @Override
    public void start() {
        this._indexCurrent = 0;
    }

    @Override
    public Question next() {
        Question result = null;
        if (this._indexCurrent < this._questions.size()) {
            result = this._questions.get(this._indexCurrent);
            this._indexCurrent++;
        }
        return result;
    }

    @Override
    public int questionsCount() {
        return _questions.size();
    }

    private final List<Question> _questions;

    private int _indexCurrent = 0;
}
