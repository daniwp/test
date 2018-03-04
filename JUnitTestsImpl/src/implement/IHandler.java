package implement;

import entities.Person;

import java.util.List;

public interface IHandler {
    List<Person> getPersonsByName(String name);

    List<Person> getAllPersons(String path);

    List<Person> sortPersonsByName();

    List<Person> sortPersonsByAge();

    List<Person> getPersonsWithPet(String pet);

    List<Person> getPersonsWithFavoritePet(String pet);

    List<Person> getPersonsWithChild(String child);

    List<Person> getPersonsWithFavoriteChild(String child);

    List<Person> getPersonsWithoutPets();

    List<Person> getPersonsWithoutChildren();
}
