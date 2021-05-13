package pl.juniorjavadeveloper.examples.hibernate.basic.entity.id.embedded;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIES")
public class Movie {
    @EmbeddedId
    private MovieId movieId;

    private String description;

    public Movie() {
    }

    public Movie(MovieId movieId, String description) {
        this.movieId = movieId;
        this.description = description;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public void setMovieId(MovieId movieId) {
        this.movieId = movieId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
