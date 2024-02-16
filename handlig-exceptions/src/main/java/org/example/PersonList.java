package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonList {
    private List<Person> person_list =  new ArrayList<Person>();
    private static int lastAssignedID=1;

    public void addPersonToList(Person person){
        lastAssignedID++;
        person_list.add(person);
    }

    public List<Person> getPersonList(){
        return person_list;
    }

    public Person finByName(String name_to_find) throws IllegalArgumentException{
        if(!Person.validateName(name_to_find)){
           throw new IllegalArgumentException("Name bad formatted");
        }

        for (Person current_person: person_list){
            if (current_person.getName().equals(name_to_find) ){
                return current_person;
            }
        }
        return null;

    }
    public Person clone(Person person_to_clone){
        lastAssignedID =lastAssignedID ++;
        return new Person(lastAssignedID, person_to_clone.getName(), person_to_clone.getAge(), person_to_clone.getOccupation());
    }

    public void createPersonFile(Person person) throws IOException {


        String file_name = "person_info"+person.getId()+".txt";
        String person_line = valueToString(person.getId()) +","+
                             person.getName()+","+
                             valueToString(person.getAge())+","+
                             person.getOccupation()+"\n";

        try {
            FileWriter fileWriter = new FileWriter(file_name, false);
            fileWriter.write(person_line);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static String valueToString(int number){
        String output = Objects.toString(number);

        return output;
    }


}
