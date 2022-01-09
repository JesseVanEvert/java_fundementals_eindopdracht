package nl.inholland.jessevanevert625868endassingment.Models;

import java.time.LocalDateTime;
import java.util.HashSet;

public class DataObject {

    private final HashSet<Person> peopleSet = new HashSet<>();
    private final HashSet<Movie> room1Movies = new HashSet<>();
    private final HashSet<Movie> room2Movies = new HashSet<>();

    public DataObject() {
        User user1 = new User(1, "user", "p@SSw0rd123");
        this.addPerson(user1);
        Admin admin1 = new Admin(1, "admin", "p@SSw0rd123");
        this.addPerson(admin1);
        Movie fightClub = new Movie(1, LocalDateTime.of(2022, 2, 13, 15, 45),
                LocalDateTime.of(2012, 2, 13, 17, 45), "Fight Club", 100, 12.5);
        room1Movies.add(fightClub);
        Movie shawshanksRedemption = new Movie(2, LocalDateTime.of(2022, 2, 13, 15, 45),
                LocalDateTime.of(2012, 2, 13, 17, 45), "Shawshanks Redemption", 100, 12.5);
        room2Movies.add(shawshanksRedemption);
    }

    public int getRoomMoviesCount(){
        return (this.room1Movies.size() + this.room2Movies.size());
    }

    public HashSet<Movie> getRoom1MoviesSet(){
        return this.room1Movies;
    }
    public HashSet<Movie> getRoom2MoviesSet(){
        return this.room2Movies;
    }

    public int getPeopleSetCount(){
        return this.peopleSet.size();
    }

    public void addPerson(Person person){
        this.peopleSet.add(person);
    }

    public Person getPersonByUsername(String username){
        for (Person person : peopleSet) {
            if (person.getUsername().equals(username)){
                return person;
            }
        }
        return null;
    }
}
