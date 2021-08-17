package packme.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private String type;
    private Date releaseDate;
    private int duration;
    private List<Character> characterList = new ArrayList<>(); //always initialize list

    public Movie(int id, String title, String type, Date releaseDate, int duration, List<Character> characterList) {
        this.setId(id);
        this.setTitle(title);
        this.setType(type);
        this.setReleaseDate(releaseDate);
        this.setDuration(duration);
        this.setCharacterList(characterList);
    }

    public Movie(String title, String type) {
        this.setTitle(title);
        this.setType(type);
    }

    public Movie(int id, String title, String type) {
        this.setId(id);
        this.setTitle(title);
        this.setType(type);
    }

    public Movie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title is empty");
        }

        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        Date date = new Date(System.currentTimeMillis());
        if (releaseDate.after(date)){
            throw new IllegalArgumentException("Can't be after today");
        }

        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration<=0) {
            throw  new IllegalArgumentException("Duration can't be negative");
        }

        this.duration = duration;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    public void addCharacter(Character character) {
        if (characterList.contains(character)){
            throw new IllegalArgumentException("The character already exists");
        }
        this.characterList.add(character);
    }
}
