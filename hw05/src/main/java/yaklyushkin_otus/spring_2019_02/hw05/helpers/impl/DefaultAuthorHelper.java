package yaklyushkin_otus.spring_2019_02.hw05.helpers.impl;

import yaklyushkin_otus.spring_2019_02.hw05.builders.AuthorBuilder;
import yaklyushkin_otus.spring_2019_02.hw05.domain.Author;
import yaklyushkin_otus.spring_2019_02.hw05.exceptions.WrongDataException;
import yaklyushkin_otus.spring_2019_02.hw05.helpers.AuthorHelper;
import yaklyushkin_otus.spring_2019_02.hw05.helpers.StringDataHolder;
import yaklyushkin_otus.spring_2019_02.hw05.service.AuthorService;
import yaklyushkin_otus.spring_2019_02.hw05.service.MessageService;

import java.util.List;

public class DefaultAuthorHelper implements AuthorHelper {

    public DefaultAuthorHelper(String language, MessageService msgService, AuthorService authorService) {
        this.authorBuilder = new AuthorBuilder(language, msgService);
        this.authorService = authorService;
    }

    @Override
    public Author create(String authorSurname, String authorName, String authorPatronymic)
            throws WrongDataException {
        Author author = this.authorBuilder.build(0, authorSurname, authorName, authorPatronymic);
        return this.authorService.insert(author);
    }

    @Override
    public Author change(long authorId, StringDataHolder authorSurname, StringDataHolder authorName, StringDataHolder authorPatronymic)
            throws WrongDataException {
        Author author = this.authorService.getById(authorId);
        String surname = authorSurname.getValue();
        if (!authorSurname.isNeedToChange()) {
            surname = author.getAuthorSurname();
        }
        String name = authorName.getValue();
        if (!authorName.isNeedToChange()) {
            name = author.getAuthorName();
        }
        String patronymic =  authorPatronymic.getValue();
        if (!authorPatronymic.isNeedToChange()) {
            patronymic = author.getAuthorPatronymic();
        }
        author = this.authorBuilder.build(authorId, surname, name, patronymic);
        return this.authorService.update(author);
    }

    @Override
    public Author remove(long authorId) {
        return this.authorService.deleteById(authorId);
    }

    @Override
    public Author get(long authorId) {
        return this.authorService.getById(authorId);
    }

    @Override
    public List<Author> getAll() {
        return this.authorService.getAll();
    }

    private final AuthorBuilder authorBuilder;

    private final AuthorService authorService;
}
