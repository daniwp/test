package implement;

import entities.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Handler implements IHandler {

    @Override
    public ArrayList<Person> getAllPersons(String path) {
        File file = new File(path);
        FileInputStream fis = null;
        ArrayList<Person> persons = new ArrayList<>();
        try {
            fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                Person person = new Person(row[0], row[1], Integer.parseInt(row[2]));
                persons.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            return persons;
        }
    }

    @Override
    public List<Person> getPersonsByName(List<Person> persons, String name) {
        List<Person> array = new ArrayList<>();

        for (Person person : persons) {
            if (person.getFirstname().equals(name)) {
                array.add(person);
            }
        }

        return array;
    }

    @Override
    public List<Person> sortPersonsByName(List<Person> persons) {
        List<Person> array = persons;

        array.sort(Comparator.comparing((Person p )-> p.getFirstname() + p.getLastname()));

        return array;
    }

    @Override
    public List<Person> sortPersonsByAge(List<Person> persons) {
        List<Person> array = persons;

        array.sort(Comparator.comparing(Person::getAge));

        return array;
    }

    @Override
    public List<Person> getPersonsWithPet(List<Person> persons, String pet) {
        List<Person> array = new ArrayList<>();

        for (Person person : persons) {
            for (String curPet : person.getPets()) {
                if (curPet.equals(pet)) {
                    array.add(person);
                }
            }
        }

        return array;
    }

    @Override
    public List<Person> getPersonsWithFavoritePet(List<Person> persons, String pet) {
        List<Person> array = new ArrayList<>();

        for (Person person : persons) {
            if (person.getFavoritePet() != null && person.getFavoritePet().equals(pet)) {
                array.add(person);
            }
        }

        return array;
    }

    @Override
    public List<Person> getPersonsWithChild(List<Person> persons, String child) {
        List<Person> array = new ArrayList<>();

        for (Person person : persons) {
            for (String curChild : person.getChildren()) {
                if (curChild.equals(child)) {
                    array.add(person);
                }
            }
        }

        return array;
    }

    @Override
    public List<Person> getPersonsWithFavoriteChild(List<Person> persons, String child) {
        List<Person> array = new ArrayList<>();

        for (Person person : persons) {
            if (person.getFavoriteChild() != null && person.getFavoriteChild().equals(child)) {
                array.add(person);
            }
        }

        return array;
    }

    @Override
    public List<Person> getPersonsWithoutPets(List<Person> persons) {
        List<Person> array = new ArrayList<>();

        for (Person person : persons) {
            if (person.getPets().isEmpty()) {
                array.add(person);
            }
        }

        return array;
    }

    @Override
    public List<Person> getPersonsWithoutChildren(List<Person> persons) {
        List<Person> array = new ArrayList<>();

        for (Person person : persons) {
            if (person.getChildren().isEmpty()) {
                array.add(person);
            }
        }

        return array;
    }
}
