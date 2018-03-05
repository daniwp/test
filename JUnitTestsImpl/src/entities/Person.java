package entities;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String firstname;
    private String lastname;
    private int age;
    private String favoritePet;
    private String favoriteChild;
    private List<String> pets;
    private List<String> children;

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.pets = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addPet(String pet) {
        this.pets.add(pet);
    }

    public void addChild(String child) {
        this.children.add(child);
    }

    public String getFirstname() {
        return firstname;
    }

    public int getAge() {
        return age;
    }

    public String getFavoritePet() {
        return favoritePet;
    }

    public String getLastname() { return lastname; }

    public void setFavoritePet(String favoritePet) {
        for (String pet : pets) {
            if (pet.equals(favoritePet)) {
                this.favoritePet = favoritePet;
                return;
            }
        }
    }

    public String getFavoriteChild() {
        return favoriteChild;
    }

    public void setFavoriteChild(String favoriteChild) {
        for (String child : children) {
            if (child.equals(favoriteChild)) {
                this.favoriteChild = favoriteChild;
                return;
            }
        }
    }

    public List<String> getPets() {
        return pets;
    }

    public List<String> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + age;
    }
}
