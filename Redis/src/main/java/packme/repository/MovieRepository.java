package packme.repository;

import packme.model.Character;
import packme.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private List<Movie> movieList = new ArrayList<>();

    public List<Movie> getAll() {
        return this.movieList;
    }

    public Movie getById(int id) {
        for(Movie m : movieList) {
            if(id == m.getId()) {
                return m;
            }
        }
        return null;
    }

    public void addMovie(Movie movie) {
        this.movieList.add(movie);
    }

    public void addMovieCharacter(int id, Character character) {
        this.movieList.get(id).addCharacter(character);
    }


    public void addMovieCharacters(int id, List<Character> characters) {
        this.movieList.get(id).setCharacterList(characters);
    }

    public List<Character> getMovieCharacters(int id) {
        return this.movieList.get(id).getCharacterList();
    }

    public List<Character> getAllCharacters(){
        List<Character> allCharacters = new ArrayList<>();
        for(Movie movie:movieList) {
            for (Character character:movie.getCharacterList()){
                allCharacters.add(character);
            }
        }
        return allCharacters;
    }
}
