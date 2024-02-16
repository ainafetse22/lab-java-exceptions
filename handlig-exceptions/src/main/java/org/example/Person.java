package org.example;

import java.util.Objects;


public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        setId(id);
        setName(name);
        setAge(age);
        setOccupation(occupation);
    }

    public static boolean validateName(String name){
        String[] name_split = name.split(" ");
        return  !(name_split.length !=2 || !Character.isUpperCase(name_split[0].charAt(0)) || !Character.isUpperCase(name_split[1].charAt(0)) );
    }
    public void setName(String name){
        if (validateName(name)){
            this.name = name;
        }
        else{
            throw  new IllegalArgumentException("Name should be formatted 'Firstname Lastname' Example Jon Doe");
        }
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if(age<0){
         throw new IllegalArgumentException("age is less than 0");
        }
        this.age=age;
    }
    public boolean equals(Person person){
        return name.equals(person.name) &&
                age == person.age &&
                occupation.equals(person.occupation);
    }
}
