import packme.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packme.repository.MovieRepository;
import static org.junit.jupiter.api.Assertions.*;

public class MovieRepositoryTest {

    MovieRepository movieRepository;

    @BeforeEach
    void initAll() {
        movieRepository = new MovieRepository();
        Movie movie1 = new Movie(1, "Movie 1", "Drama");
        Movie movie2 = new Movie(7, "Movie 2", "Comedy");
        movieRepository.addMovie(movie1);
        movieRepository.addMovie(movie2);
    }


    @Test
    public void getByIdReturnsMovie() {
        assertEquals("Movie 2", movieRepository.getById(7).getTitle());
    }
}
