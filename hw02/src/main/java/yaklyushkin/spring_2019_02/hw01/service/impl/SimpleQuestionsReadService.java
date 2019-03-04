package yaklyushkin.spring_2019_02.hw01.service.impl;

import yaklyushkin.spring_2019_02.hw01.consts.Consts;
import yaklyushkin.spring_2019_02.hw01.dao.QuestionsDAO;
import yaklyushkin.spring_2019_02.hw01.domain.Question;
import yaklyushkin.spring_2019_02.hw01.exceptions.WrongDataException;
import yaklyushkin.spring_2019_02.hw01.service.QuestionsReadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.List;
import java.util.Locale;

@Service
public class SimpleQuestionsReadService implements QuestionsReadService {

    @Autowired
    public SimpleQuestionsReadService(QuestionsDAO dao) throws WrongDataException {
        this.questions = dao.read();
        if (this.questions == null) {
            throw new WrongDataException(this.msgError);
        }
    }

    @PostConstruct
    public void init() {
        Locale locale = Consts.getLocale(this.language);
        this.msgError = messageSource.getMessage(
                Consts.MSG_QUESTIONS_READ_ERROR, null, locale);
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

    @Value("${common.language}")
    private String language;

    @Autowired
    private MessageSource messageSource;

    private String msgError;
}
