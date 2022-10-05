package ass2.bjs;
import assn2.bjs.BillMovieExcept;
import assn2.bjs.Movie;
import assn2.bjs.MovieStore;

public class MovieStoreDriver {
    

    public static void main(String[] args) throws BillMovieExcept {
        
        MovieStore MS1 = new MovieStore();

        Movie StarWars = new Movie("Star Wars");
        MS1.addMovie(StarWars);
        StarWars.addRating(4);
        StarWars.addRating(4);
        StarWars.addRating(5);
        
        Movie StarTrek = new Movie("Star Trek");
        MS1.addMovie(StarTrek);
        StarTrek.addRating(2);

        Movie AFGM = new Movie("A Few Good Men");
        MS1.addMovie(AFGM);

        Movie EndersGame = new Movie("Enders Game");
        EndersGame.addRating(5);
        MS1.addMovie(EndersGame);

        //Movie StarTrek2 = new Movie("Star Trek");
        //MS1.addMovie(StarTrek2);

        System.out.println(MS1.returnList(10));
        System.out.println(MS1.returnList(2));

    }
}
