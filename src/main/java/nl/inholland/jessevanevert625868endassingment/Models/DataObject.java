package nl.inholland.jessevanevert625868endassingment.Models;

import javafx.scene.Parent;

import java.util.HashSet;

public class DataObject {

    private final HashSet<Person> peopleSet = new HashSet<>();

    public DataObject() {
        User user1 = new User(1, "username", "p@SSw0rd123");
        this.addPerson(user1);
        Admin admin1 = new Admin(1, "admin", "p@SSw0rd123");
        this.addPerson(admin1);
    }

    public int getPeopleSetCount(){
        return this.peopleSet.size();
    }
    public void addPerson(Person person){
        this.peopleSet.add(person);
    }
    public Person getPersonByUsername(String username){
        for (Person person : peopleSet) {
            if (person.getUsername() == username){
                return person;
            }
        }
        return null;
    }
}
