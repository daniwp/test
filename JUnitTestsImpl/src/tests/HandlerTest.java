package tests;


import entities.Person;
import implement.Handler;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {

    private Handler handler;
    private List<Person> personsUnsorted = new ArrayList<>();

    @BeforeEach
    void testInit() {
        String path = System.getProperty("user.dir") + "/src/tests/convertcsvtest.csv";
        handler = new Handler(path);
        personsUnsorted = handler.persons;
    }

    @org.junit.jupiter.api.Test
    void getPersonsByName() {
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Hans", "Jørgensen", 32));
        expected.add(new Person("Hans", "Hansen", 22));
        expected.add(new Person("Hans", "Larsen", 52));

        actual = handler.getPersonsByName("Hans");

        assertAll("Persons with name = Hans",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 3);
                    assertAll("Specific person",
                            () -> assertEquals(expected.get(0).getFirstname(), actual.get(0).getFirstname()),
                            () -> assertEquals(expected.get(1).getFirstname(), actual.get(1).getFirstname()),
                            () -> assertEquals(expected.get(2).getFirstname(), actual.get(2).getFirstname())
                    );
                });
    }

    @org.junit.jupiter.api.Test
    void getAllPersons() {
        int expectedSize = 6;
        int actualSize;

        actualSize = personsUnsorted.size();

        assertEquals(expectedSize, actualSize);
    }

    @org.junit.jupiter.api.Test
    void sortPersonsByName() {
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Bettie", "Dawson", 35));
        expected.add(new Person("Hans", "Hansen", 22));
        expected.add(new Person("Hans", "Jørgensen", 32));
        expected.add(new Person("Hans", "Larsen", 52));
        expected.add(new Person("Lettie", "Bowers", 35));
        expected.add(new Person("Walter", "Pearson", 36));

        actual = handler.sortPersonsByName();

        assertAll("Persons sorted by name",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 6);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).getFirstname(), actual.get(0).getFirstname()),
                            () -> assertEquals(expected.get(1).getFirstname(), actual.get(1).getFirstname()),
                            () -> assertEquals(expected.get(2).getFirstname(), actual.get(2).getFirstname()),
                            () -> assertEquals(expected.get(3).getFirstname(), actual.get(3).getFirstname()),
                            () -> assertEquals(expected.get(4).getFirstname(), actual.get(4).getFirstname()),
                            () -> assertEquals(expected.get(5).getFirstname(), actual.get(5).getFirstname())
                    );
                });
    }

    @org.junit.jupiter.api.Test
    void sortPersonsByAge() {
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Hans", "Hansen", 22));
        expected.add(new Person("Hans", "Jørgensen", 32));
        expected.add(new Person("Bettie", "Dawson", 35));
        expected.add(new Person("Lettie", "Bowers", 35));
        expected.add(new Person("Walter", "Pearson", 36));
        expected.add(new Person("Hans", "Larsen", 52));

        actual = handler.sortPersonsByAge();

        assertAll("Persons sorted by age",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 6);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).getAge(), actual.get(0).getAge()),
                            () -> assertEquals(expected.get(1).getAge(), actual.get(1).getAge()),
                            () -> assertEquals(expected.get(2).getAge(), actual.get(2).getAge()),
                            () -> assertEquals(expected.get(3).getAge(), actual.get(3).getAge()),
                            () -> assertEquals(expected.get(4).getAge(), actual.get(4).getAge()),
                            () -> assertEquals(expected.get(5).getAge(), actual.get(5).getAge())
                    );
                });
    }

    @org.junit.jupiter.api.Test
    void getPersonsWithPet() {
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Hans", "Hansen", 22));
        expected.add(new Person("Lettie", "Bowers", 35));

        personsUnsorted.get(1).addPet("Cat");
        personsUnsorted.get(1).addPet("Dog");
        personsUnsorted.get(2).addPet("Cat");
        personsUnsorted.get(3).addPet("Lizard");
        personsUnsorted.get(4).addPet("Dog");

        actual = handler.getPersonsWithPet("Cat");

        assertAll("Persons with pet = Cat",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 2);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).getFirstname(), actual.get(0).getFirstname()),
                            () -> assertEquals(expected.get(1).getFirstname(), actual.get(1).getFirstname())
                    );
                });
    }

    @org.junit.jupiter.api.Test
    void getPersonsWithFavoritePet() {
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Hans", "Hansen", 22));
        expected.add(new Person("Walter", "Pearson", 36));

        personsUnsorted.get(1).addPet("Dog");
        personsUnsorted.get(1).setFavoritePet("Dog");
        // Favorite pet cannot be set if person does not currently have pet
        personsUnsorted.get(2).setFavoritePet("Dog");
        personsUnsorted.get(3).addPet("Lizard");
        personsUnsorted.get(3).setFavoritePet("Lizard");
        personsUnsorted.get(4).addPet("Dog");
        personsUnsorted.get(4).setFavoritePet("Dog");

        actual = handler.getPersonsWithFavoritePet("Dog");

        assertAll("Persons with favorite pet = Dog",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 2);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).getFirstname(), actual.get(0).getFirstname()),
                            () -> assertEquals(expected.get(1).getFirstname(), actual.get(1).getFirstname())
                    );
                });
    }

    @org.junit.jupiter.api.Test
    void getPersonsWithChild() {
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Hans", "Jørgensen", 32));
        expected.add(new Person("Lettie", "Bowers", 35));
        expected.add(new Person("Walter", "Pearson", 36));

        personsUnsorted.get(0).addChild("Lis");
        personsUnsorted.get(1).addChild("Tine");
        personsUnsorted.get(2).addChild("Tine");
        personsUnsorted.get(3).addChild("Emil");
        personsUnsorted.get(4).addChild("Tine");

        actual = handler.getPersonsWithChild("Tine");

        assertAll("Persons with child named Tine",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 3);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).getFirstname(), actual.get(0).getFirstname()),
                            () -> assertEquals(expected.get(1).getFirstname(), actual.get(1).getFirstname()),
                            () -> assertEquals(expected.get(1).getFirstname(), actual.get(1).getFirstname())
                    );
                });
    }

    @org.junit.jupiter.api.Test
    void getPersonsWithFavoriteChild() {
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Bettie", "Dawson", 35));
        expected.add(new Person("Walter", "Pearson", 36));

        personsUnsorted.get(0).addChild("Anders");
        personsUnsorted.get(0).setFavoriteChild("Anders");
        personsUnsorted.get(1).addChild("Andersine");
        personsUnsorted.get(1).setFavoriteChild("Andersine");
        // Favorite pet cannot be set if person does not currently have pet
        personsUnsorted.get(2).setFavoriteChild("Anders");
        personsUnsorted.get(3).addChild("Andersine");
        personsUnsorted.get(3).setFavoriteChild("Andersine");
        personsUnsorted.get(4).addChild("Anders");
        personsUnsorted.get(4).setFavoriteChild("Anders");

        actual = handler.getPersonsWithFavoriteChild("Anders");

        assertAll("Persons with favorite child named Anders",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 2);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).getFirstname(), actual.get(0).getFirstname()),
                            () -> assertEquals(expected.get(1).getFirstname(), actual.get(1).getFirstname())
                    );
                });
    }

    @org.junit.jupiter.api.Test
    void getPersonsWithoutPets() {
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Bettie", "Dawson", 35));
        expected.add(new Person("Hans", "Larsen", 52));

        personsUnsorted.get(1).addPet("Cat");
        personsUnsorted.get(1).addPet("Dog");
        personsUnsorted.get(2).addPet("Cat");
        personsUnsorted.get(3).addPet("Lizard");
        personsUnsorted.get(4).addPet("Dog");

        actual = handler.getPersonsWithoutPets();

        assertAll("Persons without pets",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 2);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).getFirstname(), actual.get(0).getFirstname()),
                            () -> assertEquals(expected.get(1).getFirstname(), actual.get(1).getFirstname())
                    );
                });
    }

    @org.junit.jupiter.api.Test
    void getPersonsWithoutChildren() {
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Bettie", "Dawson", 35));
        expected.add(new Person("Hans", "Larsen", 52));

        personsUnsorted.get(1).addChild("Tine");
        personsUnsorted.get(1).addChild("Hans");
        personsUnsorted.get(2).addChild("Lærke");
        personsUnsorted.get(3).addChild("Stine");
        personsUnsorted.get(4).addChild("Frederik");

        actual = handler.getPersonsWithoutChildren();

        assertAll("Persons without children",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 2);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).getFirstname(), actual.get(0).getFirstname()),
                            () -> assertEquals(expected.get(1).getFirstname(), actual.get(1).getFirstname())
                    );
                });
    }
}