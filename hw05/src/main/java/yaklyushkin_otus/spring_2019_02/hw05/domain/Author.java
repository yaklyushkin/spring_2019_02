package yaklyushkin_otus.spring_2019_02.hw05.domain;

import java.util.Objects;

public class Author {

    public Author(int authorId, String authorSurname, String authorName, String authorPatronymic) {
        this.authorId = authorId;
        this.authorSurname = authorSurname;
        this.authorName = authorName;
        this.authorPatronymic = authorPatronymic;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorPatronymic() {
        return authorPatronymic;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other == null) ||
            (getClass() != other.getClass())) {
            return false;
        }
        Author author = (Author) other;
        return (authorId == author.authorId) &&
               (Objects.equals(authorSurname, author.authorSurname)) &&
               (Objects.equals(authorName, author.authorName)) &&
               (Objects.equals(authorPatronymic, author.authorPatronymic));
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorSurname, authorName, authorPatronymic);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorSurname='" + authorSurname + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorPatronymic='" + authorPatronymic + '\'' +
                '}';
    }

    private final int authorId;

    private final String authorSurname;

    private final String authorName;

    private final String authorPatronymic;
}
