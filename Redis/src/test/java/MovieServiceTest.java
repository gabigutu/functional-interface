import packme.model.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import packme.repository.MovieRepository;
import packme.service.MovieService;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    MovieRepository movieRepository;

    MovieService movieService;

//    @BeforeAll
//    static void initAll() {
//        movieService = new MovieService(movieRepository);
//    }

    @Test
    public void getAllReturnsList() {
        movieService = new MovieService(movieRepository);
        List<Movie> movieList = new ArrayList<>();
        Movie movie1 = new Movie("Movie 1", "Drama");
        movieList.add(movie1);
        when(movieRepository.getAll()).thenReturn(movieList);
        List<Movie> movies = movieService.getAll();
        assertEquals(1,movies.size());
    }

    @Test
    public void getAllReturnsNull() {
        movieService = new MovieService(movieRepository);
        when(movieRepository.getAll()).thenReturn(null);
        List<Movie> movies = movieService.getAll();
        assertNull(movies);
    }

    @Test
    public void getAllReturnsEmpty() {
        movieService = new MovieService(movieRepository);
        when(movieRepository.getAll()).thenReturn(new ArrayList<>());
        List<Movie> movies = movieService.getAll();
        assertEquals(0, movies.size());
    }


}
