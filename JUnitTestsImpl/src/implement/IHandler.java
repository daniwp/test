package implement;

import entities.Person;

import java.util.List;

public interface IHandler {
    List<Person> getPersonsByName(List<Person> persons, String name);

    List<Person> getAllPersons(String path);

    List<Person> sortPersonsByName(List<Person> persons);

    List<Person> sortPersonsByAge(List<Person> persons);

    List<Person> getPersonsWithPet(List<Person> persons, String pet);

    List<Person> getPersonsWithFavoritePet(List<Person> persons, String pet);

    List<Person> getPersonsWithChild(List<Person> persons, String child);

    List<Person> getPersonsWithFavoriteChild(List<Person> persons, String child);

    List<Person> getPersonsWithoutPets(List<Person> persons);

    List<Person> getPersonsWithoutChildren(List<Person> persons);
}
