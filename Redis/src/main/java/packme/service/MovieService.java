package packme.service;

import packme.model.Character;
import packme.model.Movie;
import packme.repository.MovieRepository;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    public Movie getById(int id) {
        return this.movieRepository.getById(id);
    }

    public Boolean addMovie(String title, String type, String releaseDate,int duration) throws ParseException {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setType(type);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        movie.setReleaseDate(simpleDateFormat.parse(releaseDate));
        movie.setDuration(duration);
        this.movieRepository.addMovie(movie);
        return true;
    }

    public Boolean addMovieCharacter(int id, Character character) {
        this.movieRepository.addMovieCharacter(id,character);
        return true;
    }
}
