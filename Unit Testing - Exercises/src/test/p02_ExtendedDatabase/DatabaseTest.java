package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Person[] PEOPLE = {new Person(1, "Ivan"), new Person(2, "Peter"), new Person(3, "Lucy")};
    private static final Person[] EMPTY_PEOPLE = new Person[0];
    private static final Person[] HUGE_PEOPLE = new Person[17];
    private static final Person VALID_PERSON = new Person(7, "Miro");
    private static final Person INVALID_PERSON = null;
    private static final String INVALID_USERNAME = null;
    private static final Person WRONG_USER = new Person(11, "Maria");
    private static Database database;

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorCreatValidObject() {
        Assert.assertArrayEquals(PEOPLE, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionForEmptyArray() throws OperationNotSupportedException {
        new Database(EMPTY_PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionForHugeArray() throws OperationNotSupportedException {
        new Database(HUGE_PEOPLE);
    }

    @Test
    public void testAddValidPerson() throws OperationNotSupportedException {
        database.add(VALID_PERSON);
        Assert.assertEquals(PEOPLE.length + 1, database.getElements().length);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], VALID_PERSON);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddInvalidPerson() throws OperationNotSupportedException {
        database.add(INVALID_PERSON);
    }

    @Test
    public void testRemoveFromValidDatabase() throws OperationNotSupportedException {
        database.remove();
        Assert.assertNotEquals(PEOPLE[PEOPLE.length - 1], database.getElements()[database.getElements().length - 1]);
        Assert.assertEquals(PEOPLE.length - 1, database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDatabase() throws OperationNotSupportedException {
        int iterations = database.getElements().length;
        for (int i = 0; i < iterations; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testGetElements() {
        Assert.assertArrayEquals(PEOPLE, database.getElements());
    }

    @Test
    public void testFindWithValidUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername(PEOPLE[0].getUsername());
        Assert.assertEquals(PEOPLE[0], person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindWithNullUsernameThrowsException() throws OperationNotSupportedException {
        database.findByUsername(INVALID_USERNAME);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindWithWrongUsernameThrowsException() throws OperationNotSupportedException {
        database.findByUsername(WRONG_USER.getUsername());
    }

    @Test
    public void testFindWithValidId() throws OperationNotSupportedException {
        Person person = database.findById(PEOPLE[0].getId());
        Assert.assertEquals(PEOPLE[0], person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindWithNotExistingId() throws OperationNotSupportedException {
        database.findById(WRONG_USER.getId());
    }
}