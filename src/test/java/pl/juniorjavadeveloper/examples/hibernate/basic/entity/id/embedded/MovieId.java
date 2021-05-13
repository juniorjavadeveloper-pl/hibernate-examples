package pl.juniorjavadeveloper.examples.hibernate.basic.entity.id.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MovieId implements Serializable {
    private String movieTitle;
    private String movieTag;

    public MovieId() {
    }

    public MovieId(String movieTitle, String movieTag) {
        this.movieTitle = movieTitle;
        this.movieTag = movieTag;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieTag() {
        return movieTag;
    }

    public void setMovieTag(String movieTag) {
        this.movieTag = movieTag;
    }
}
