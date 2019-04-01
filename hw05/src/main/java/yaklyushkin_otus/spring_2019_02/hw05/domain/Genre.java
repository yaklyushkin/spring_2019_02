package yaklyushkin_otus.spring_2019_02.hw05.domain;

import java.util.Objects;

public class Genre {

    public Genre(int genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
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
        Genre genre = (Genre) other;
        return (genreId == genre.genreId) &&
               (Objects.equals(genreName, genre.genreName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, genreName);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                '}';
    }

    private final int genreId;

    private final String genreName;
}
