package yaklyushkin.spring_2019_02.hw04.service.impl;

import yaklyushkin.spring_2019_02.hw04.consts.Consts;
import yaklyushkin.spring_2019_02.hw04.dao.QuestionsDAO;
import yaklyushkin.spring_2019_02.hw04.domain.Question;
import yaklyushkin.spring_2019_02.hw04.exceptions.WrongDataException;
import yaklyushkin.spring_2019_02.hw04.service.MessageService;
import yaklyushkin.spring_2019_02.hw04.service.QuestionsReadService;

import java.util.List;
import java.util.Locale;

public class SimpleQuestionsReadService implements QuestionsReadService {

    public SimpleQuestionsReadService(
            String language,
            MessageService messageSource,
            QuestionsDAO dao) throws WrongDataException {
        Locale locale = Consts.getLocale(language);
        String msgError = messageSource.getMessage(
                Consts.MSG_QUESTIONS_READ_ERROR, null, locale);

        this.questions = dao.read();
        if (this.questions == null) {
            throw new WrongDataException(msgError);
        }
    }

    @Override
    public void start() {
        this.indexCurrent = 0;
    }

    @Override
    public Question next() {
        Question result = null;
        if (this.indexCurrent < this.questions.size()) {
            result = this.questions.get(this.indexCurrent);
            this.indexCurrent++;
        }
        return result;
    }

    @Override
    public int questionsCount() {
        return questions.size();
    }

    private final List<Question> questions;

    private int indexCurrent = 0;
}
