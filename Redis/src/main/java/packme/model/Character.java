package packme.model;

import java.util.Objects;

public class Character {
    private String name;
    private int age;

    public Character(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<=0){
            throw new IllegalArgumentException("Age can't be negative");
        }
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return age == character.age && Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
