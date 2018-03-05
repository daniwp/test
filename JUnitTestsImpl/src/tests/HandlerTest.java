package tests;


import entities.Person;
import implement.Handler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {

    private Handler handler;
    private List<Person> personsUnsorted = new ArrayList<>();
    private String path = System.getProperty("user.dir") + "/src/tests/convertcsvtest.csv";

    @BeforeEach
    void testInit() {
        handler = new Handler();
        personsUnsorted.add(new Person("Bettie", "Dawson",35));
        personsUnsorted.add(new Person("Hans", "Jørgensen",32));
        personsUnsorted.add(new Person("Lettie", "Bowers",35));
        personsUnsorted.add(new Person("Hans", "Hansen",22));
        personsUnsorted.add(new Person("Walter", "Pearson",36));
        personsUnsorted.add(new Person("Hans", "Larsen",52));
    }

    @Test
    void getPersonsByName() {
        // Arrange
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Hans", "Jørgensen", 32));
        expected.add(new Person("Hans", "Hansen", 22));
        expected.add(new Person("Hans", "Larsen", 52));

        // Act
        actual = handler.getPersonsByName(personsUnsorted,"Hans");

        // Assert
        assertAll("Persons with name = Hans",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 3);
                    assertAll("Specific person",
                            () -> assertEquals(expected.get(0).toString(), actual.get(0).toString()),
                            () -> assertEquals(expected.get(1).toString(), actual.get(1).toString()),
                            () -> assertEquals(expected.get(2).toString(), actual.get(2).toString())
                    );
                });
    }

    @Test
    void getAllPersons() {
        // Arrange
        int expectedSize = 6;
        int actualSize;

        // Act
        actualSize = handler.getAllPersons(path).size();

        // Assert
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void sortPersonsByName() {
        // Arrange
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Bettie", "Dawson", 35));
        expected.add(new Person("Hans", "Hansen", 22));
        expected.add(new Person("Hans", "Jørgensen", 32));
        expected.add(new Person("Hans", "Larsen", 52));
        expected.add(new Person("Lettie", "Bowers", 35));
        expected.add(new Person("Walter", "Pearson", 36));

        // Act
        actual = handler.sortPersonsByName(personsUnsorted);

        // Assert
        assertAll("Persons sorted by name",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 6);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).toString(), actual.get(0).toString()),
                            () -> assertEquals(expected.get(1).toString(), actual.get(1).toString()),
                            () -> assertEquals(expected.get(2).toString(), actual.get(2).toString()),
                            () -> assertEquals(expected.get(3).toString(), actual.get(3).toString()),
                            () -> assertEquals(expected.get(4).toString(), actual.get(4).toString()),
                            () -> assertEquals(expected.get(5).toString(), actual.get(5).toString())
                    );
                });
    }

    @Test
    void sortPersonsByAge() {
        // Arrange
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Hans", "Hansen", 22));
        expected.add(new Person("Hans", "Jørgensen", 32));
        expected.add(new Person("Bettie", "Dawson", 35));
        expected.add(new Person("Lettie", "Bowers", 35));
        expected.add(new Person("Walter", "Pearson", 36));
        expected.add(new Person("Hans", "Larsen", 52));

        // Act
        actual = handler.sortPersonsByAge(personsUnsorted);

        // Assert
        assertAll("Persons sorted by age",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 6);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).toString(), actual.get(0).toString()),
                            () -> assertEquals(expected.get(1).toString(), actual.get(1).toString()),
                            () -> assertEquals(expected.get(2).toString(), actual.get(2).toString()),
                            () -> assertEquals(expected.get(3).toString(), actual.get(3).toString()),
                            () -> assertEquals(expected.get(4).toString(), actual.get(4).toString()),
                            () -> assertEquals(expected.get(5).toString(), actual.get(5).toString())
                    );
                });
    }

    @Test
    void getPersonsWithPet() {
        // Arrange
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Hans", "Jørgensen", 32));
        expected.add(new Person("Lettie", "Bowers", 35));

        personsUnsorted.get(1).addPet("Cat");
        personsUnsorted.get(1).addPet("Dog");
        personsUnsorted.get(2).addPet("Cat");
        personsUnsorted.get(3).addPet("Lizard");
        personsUnsorted.get(4).addPet("Dog");

        // Act
        actual = handler.getPersonsWithPet(personsUnsorted,"Cat");

        // Assert
        assertAll("Persons with pet = Cat",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 2);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).toString(), actual.get(0).toString()),
                            () -> assertEquals(expected.get(1).toString(), actual.get(1).toString())
                    );
                });
    }

    @Test
    void getPersonsWithFavoritePet() {
        // Arrange
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Hans", "Jørgensen", 32));
        expected.add(new Person("Walter", "Pearson", 36));

        personsUnsorted.get(1).addPet("Dog");
        personsUnsorted.get(1).setFavoritePet("Dog");
        // Favorite pet cannot be set if person does not currently have pet
        personsUnsorted.get(2).setFavoritePet("Dog");
        personsUnsorted.get(3).addPet("Lizard");
        personsUnsorted.get(3).setFavoritePet("Lizard");
        personsUnsorted.get(4).addPet("Dog");
        personsUnsorted.get(4).setFavoritePet("Dog");

        // Act
        actual = handler.getPersonsWithFavoritePet(personsUnsorted,"Dog");

        // Assert
        assertAll("Persons with favorite pet = Dog",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 2);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).toString(), actual.get(0).toString()),
                            () -> assertEquals(expected.get(1).toString(), actual.get(1).toString())
                    );
                });
    }

    @Test
    void getPersonsWithChild() {
        // Arrange
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

        // Act
        actual = handler.getPersonsWithChild(personsUnsorted,"Tine");

        // Assert
        assertAll("Persons with child named Tine",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 3);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).toString(), actual.get(0).toString()),
                            () -> assertEquals(expected.get(1).toString(), actual.get(1).toString()),
                            () -> assertEquals(expected.get(1).toString(), actual.get(1).toString())
                    );
                });
    }

    @Test
    void getPersonsWithFavoriteChild() {
        // Arrange
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

        // Act
        actual = handler.getPersonsWithFavoriteChild(personsUnsorted,"Anders");

        // Assert
        assertAll("Persons with favorite child named Anders",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 2);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).toString(), actual.get(0).toString()),
                            () -> assertEquals(expected.get(1).toString(), actual.get(1).toString())
                    );
                });
    }

    @Test
    void getPersonsWithoutPets() {
        // Arrange
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Bettie", "Dawson", 35));
        expected.add(new Person("Hans", "Larsen", 52));

        personsUnsorted.get(1).addPet("Cat");
        personsUnsorted.get(1).addPet("Dog");
        personsUnsorted.get(2).addPet("Cat");
        personsUnsorted.get(3).addPet("Lizard");
        personsUnsorted.get(4).addPet("Dog");

        // Act
        actual = handler.getPersonsWithoutPets(personsUnsorted);

        // Assert
        assertAll("Persons without pets",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 2);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).toString(), actual.get(0).toString()),
                            () -> assertEquals(expected.get(1).toString(), actual.get(1).toString())
                    );
                });
    }

    @Test
    void getPersonsWithoutChildren() {
        // Arrange
        List<Person> expected = new ArrayList<>();
        List<Person> actual;

        expected.add(new Person("Bettie", "Dawson", 35));
        expected.add(new Person("Hans", "Larsen", 52));

        personsUnsorted.get(1).addChild("Tine");
        personsUnsorted.get(1).addChild("Hans");
        personsUnsorted.get(2).addChild("Lærke");
        personsUnsorted.get(3).addChild("Stine");
        personsUnsorted.get(4).addChild("Frederik");

        // Act
        actual = handler.getPersonsWithoutChildren(personsUnsorted);

        // Assert
        assertAll("Persons without children",
                () -> {
                    assertNotNull(actual);
                    assertTrue(actual.size() == 2);
                    assertAll("Person",
                            () -> assertEquals(expected.get(0).toString(), actual.get(0).toString()),
                            () -> assertEquals(expected.get(1).toString(), actual.get(1).toString())
                    );
                });
    }
}