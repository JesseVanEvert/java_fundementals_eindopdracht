package nl.inholland.jessevanevert625868endassingment.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class DataObject {

    private final HashSet<Person> peopleSet = new HashSet<>();
    private final HashSet<Movie> room1Movies = new HashSet<>();
    private final HashSet<Movie> room2Movies = new HashSet<>();
    private final double defaultPrice = 15.0;

    public DataObject() {
        User user1 = new User(1, "user", "p@SSw0rd123");
        this.addPerson(user1);
        Admin admin1 = new Admin(1, "admin", "p@SSw0rd123");
        this.addPerson(admin1);
        Movie fightClub = new Movie(1, LocalDateTime.of(2022, 2, 13, 16, 0),
                LocalDateTime.of(2022, 2, 13, 17, 45), "Fight Club", 100, 12.5, 105);
        this.addMovieToRoom1(fightClub);
        Movie pulpFiction = new Movie(2, LocalDateTime.of(2022, 2, 13, 18, 0),
                LocalDateTime.of(2022, 2, 13, 19, 45), "Pulp fiction", 100, 12.5, 105);
        this.addMovieToRoom1(pulpFiction);
        Movie shawshanksRedemption = new Movie(3, LocalDateTime.of(2022, 2, 13, 16, 45),
                LocalDateTime.of(2022, 2, 13, 17, 45), "Shawshanks Redemption", 100, 12.5, 105);
        this.addMovieToRoom2(shawshanksRedemption);
        Movie shawshanksRedemption2 = new Movie(3, LocalDateTime.of(2022, 2, 13, 18, 0),
                LocalDateTime.of(2022, 2, 13, 19, 45), "Shawshanks Redemption", 100, 12.5, 105);
        this.addMovieToRoom2(shawshanksRedemption2);
    }

    public int getRoomsMoviesCount(){
        return (this.room1Movies.size() + this.room2Movies.size());
    }

    public double findMoviePriceByName(String movieName){
        for (Movie movie : room1Movies){
            return movie.getPrice();
        }
        for (Movie movie : room2Movies){
            return movie.getPrice();
        }

        return defaultPrice;
    }

    public Movie getMovieByTitle(String title){
        for (Movie movie : room1Movies){
            if(movie.getTitle().equals(title))
                return movie;
        }
        for (Movie movie : room2Movies){
            if(movie.getTitle().equals(title))
                return movie;
        }
        return null;
    }

    public ArrayList<Movie> getRoom1MoviesStartWithTheLetters(String letters){
           ArrayList<Movie> listWithFilteredMovies = new ArrayList<>();
        for (Movie movie : room1Movies) {
            String movieTitle = movie.getTitle();
            String movieLetters = movieTitle.length() < letters.length() ? movieTitle : movieTitle.substring(0, letters.length());
            if (movieLetters.toLowerCase(Locale.ROOT).equals(letters.toLowerCase(Locale.ROOT)))
                listWithFilteredMovies.add(movie);
        }

        return listWithFilteredMovies;
    }

    public ArrayList<Movie> getRoom2MoviesStartWithTheLetters(String letters){
        ArrayList<Movie> listWithFilteredMovies = new ArrayList<>();

        for (Movie movie : room2Movies){
            String movieTitle = movie.getTitle();
            String movieLetters = movieTitle.length() < letters.length() ? movieTitle : movieTitle.substring(0, letters.length());
            if (movieLetters.toLowerCase(Locale.ROOT).equals(letters.toLowerCase(Locale.ROOT)))
                listWithFilteredMovies.add(movie);
        }
        return listWithFilteredMovies;
    }


    public HashSet<String> getAllMovieTitles(){
        HashSet<String> movieTitles = new HashSet<>();
        for (Movie movie : room1Movies){
            movieTitles.add(movie.getTitle());
        }
        for (Movie movie : room2Movies){
            movieTitles.add(movie.getTitle());
        }
        return movieTitles;
    }

    public void deductSeatsFromMovieRoom1(int id, int seats){
        for(Movie movie : room1Movies){
            if(movie.getMovieId() == id){
                movie.setSeats(movie.getSeats() - seats);
            }
        }
    }

    public void deductSeatsFromMovieRoom2(int id, int seats){
        for(Movie movie : room2Movies){
            if(movie.getMovieId() == id){
                movie.setSeats(movie.getSeats() - seats);
            }
        }
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

    public void addMovieToRoom1(Movie movie) { this.room1Movies.add(movie); }

    public void addMovieToRoom2(Movie movie) { this.room2Movies.add(movie); };

    public Person getPersonByUsername(String username){
        for (Person person : peopleSet) {
            if (person.getUsername().equals(username)){
                return person;
            }
        }
        return null;
    }
}
