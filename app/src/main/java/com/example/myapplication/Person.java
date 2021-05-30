package com.example.myapplication;

import java.util.ArrayList;

public class Person {
    private String userName;
    private String password;

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static ArrayList<Person> getPersonsList() {
        ArrayList persons = new ArrayList();
        persons.add(new Person("mertmestanli@gmail.com","1234"));
        persons.add(new Person("ssss11@gmail.com","123444"));
        persons.add(new Person("ss11@gmail.com","1444"));

        return persons;
    }
}
