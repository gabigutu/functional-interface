import packme.model.Character;
import packme.model.Movie;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;


public class MovieTest {

    @Test
    public void setDateReturnsOk(){
        Movie movie = new Movie();
        Date date = new Date(1628584852);
        movie.setReleaseDate(date);
        assertEquals(date,movie.getReleaseDate());
    }

    @Test
    public void setDateThrowsError(){
        Movie movie = new Movie();
        Date dateOfMovie = new Date(System.currentTimeMillis()+123448448);
        //movie.setReleaseDate(dateOfMovie);
        assertThrows(IllegalArgumentException.class,()->movie.setReleaseDate(dateOfMovie));
    }


    @ParameterizedTest
    @ValueSource(strings ={"Suicide Squad 2","The Expendables","Inglorious Basterds","American Psycho"})
    public void setTitleIsCorrect(String title){
        Movie movie = new Movie();
        movie.setTitle(title);
        assertEquals(title,movie.getTitle());
    }
    // test pentru title gol si title blank

    @Test
    public void addCharacterIsCorrect(){
        Character character = new Character("X",30);
        Movie movie = new Movie();
        movie.addCharacter(character);
        assertEquals(1,movie.getCharacterList().size());
    }
    @Test
    public void addCharacterSpyIsCorrect(){
        Movie movie = new Movie();
        List<Character> spyList = Mockito.spy(movie.getCharacterList());
        Character character = new Character("Y",42);
        spyList.add(character);
        Mockito.verify(spyList).add(character);

        assertEquals(1,spyList.size());
    }
}
