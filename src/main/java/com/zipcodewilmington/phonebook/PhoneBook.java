package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {


    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook =
        new LinkedHashMap<String, List<String>>(map);
    }

    public PhoneBook() {
        this( new LinkedHashMap<String, List<String>>());
    }

    public void add(String name, String phoneNumber) {
        this.phonebook.put(name, new ArrayList<String>(Arrays.asList(phoneNumber)));

    }

    public void addAll(String name, String... phoneNumbers) {
        this.phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);

    }

    public Boolean hasEntry(String name) {

        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        String personsName = "";
        for(String name : phonebook.keySet()) {
            if(phonebook.get(name).contains(phoneNumber)) {
                personsName = name;
            }
        }
        return personsName;
    }


    public List<String> getAllContactNames() {
        ArrayList<String> allContactNames = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            allContactNames.add(entry.getKey());
        }
        return allContactNames;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
