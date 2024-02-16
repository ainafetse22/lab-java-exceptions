package org.example;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestPerson {
    @Test
    public void testSetAgeOk() throws Exception {
     Person test_person = new Person(1,"Alex Doe",32,"Plumber");

     test_person.setAge(35);

     assertEquals(35,test_person.getAge());
    }

    @Test
    public void testSetAgeAssertException() throws Exception {
        Person test_person = new Person(1,"Alex Cuenca",32,"Plumber");

        assertThrows(IllegalArgumentException.class,()-> test_person.setAge(-1));
    }
    @Test
    public void testFindByNamePersonExistsWellFormatted(){
        PersonList test_list = createPersonList();
        Person test_person = new Person(1,"Jon Doe",30,"Plumber");

        Person found_person= test_list.finByName("Jon Doe");

        assertTrue(test_person.equals(found_person));
    }

    @Test
    public void testFindByNamePersonNoWellFormatted() {
        PersonList test_list = createPersonList();
        assertThrows(IllegalArgumentException.class, () -> test_list.finByName("JonDoe"));

    }


    @Test
    public void testFindByNamePersonNoExists(){
        PersonList test_list = createPersonList();
        Person test_person = new Person(1,"Jon Doe",30,"Plumber");

        Person found_person= test_list.finByName("Jona Hemps");

        assertNull(found_person);
    }

    @Test
    public void tesClone(){
        PersonList test_list = createPersonList();
        Person test_person = new Person(1,"Jon Doe",30,"Plumber");

        Person clone_person = test_list.clone(test_person);
        assertTrue("properties are equal",test_person.equals(clone_person));
        assertNotEquals(test_person.getId(),clone_person.getId());


    }

    @Test
    public void testFileWrite() throws IOException ,FileNotFoundException{
        PersonList test_list = createPersonList();
        Person test_person = test_list.finByName("Jon Doe");
        try {
            test_list.createPersonFile(test_person);
            File file = new File("person_info" + test_person.getId() + ".txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            assertEquals("1,Jon Doe,30,Plumber",line);
        }catch (NoSuchElementException e){
            fail("line not found");
        }catch (FileNotFoundException e) {
            fail("file not found");
        }
        catch (IOException e){
            fail("IoException" +e.getMessage());
        }

    }

    private <List>PersonList createPersonList(){
        Person test_person = new Person(1,"Jon Doe",30,"Plumber");
        Person test_person2 = new Person(2,"Jon Doe2",31,"Plumber");
        Person test_person3 = new Person(3,"Jon Doe3",32,"Plumber");
        PersonList test_list = new PersonList();
        test_list.addPersonToList(test_person);
        test_list.addPersonToList(test_person2);
        test_list.addPersonToList(test_person3);
        return test_list;
    }

}
