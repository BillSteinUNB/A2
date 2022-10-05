import java.util.ArrayList;
public class Movie implements Comparable<Movie>{

    public final String movieTitle;
    private ArrayList<Integer> movieRating = new ArrayList<>();
    
   
    public Movie(String movieTitleIN){

        movieTitle = movieTitleIN;        
    }

    public void addRating(Integer x) throws BillMovieExcept{
        if(x<0 || x>5){
            throw new BillMovieExcept("Sorry, Rating out of bounds, please try again with values between 0.0 - 5.0");
        }
        else if(x>=0 && x <=5){
                movieRating.add(x);
        }
    }

    public Double getRating(){
        double x = 0;
        int div = 0;
        if(movieRating.isEmpty() == true){
            return null;
        }
        else if(movieRating.size() == 1){
            return movieRating.get(0) + 0.0;
        }
        else{
            for(int i = 0; i < movieRating.size(); i++){
                x += movieRating.get(i);
                div = i;
            }

        return x/(div+1);
        }
    }

    public void clearRating(){
        movieRating.clear();
    }

    public String getTitle(){
        return movieTitle;
    }
    public Movie copyOf(){
        Movie newMovie = new Movie(movieTitle);
        newMovie.movieRating = movieRating;
        return newMovie;
    }

    public int compareTo(Movie other) {
        if(this.getRating() == null){
            return -1;
        }
        if ( other.getRating() == null){
            return 1;
        }
        return this.getRating().compareTo(((Movie) other).getRating());
    }


}

