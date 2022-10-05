package assn2.bjs;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Collections;


public class MovieStore {

    private static final DecimalFormat df = new DecimalFormat("0.0");


    private ArrayList<Movie> Inventory = new ArrayList<>();

    public MovieStore(){

    }
       
      

    public void addMovie(Movie movie) throws BillMovieExcept{
        boolean hold = true;

        for(int i = 0; i < Inventory.size(); i++){
            if(movie.getTitle() == Inventory.get(i).getTitle()){
                hold = false;
            }
        }
        if(hold == true){
            Inventory.add(movie);
        }
        else{
            throw new BillMovieExcept("Sorry movie is already in store!");
        }
    
    }

    public String returnList(int N) throws BillMovieExcept{
        String list;
        
        if(Inventory.size() == 0) {
        	throw new BillMovieExcept("Sorry, we are all out of movies!");
        }
        
        else if(N > Inventory.size() ){
            list = "All Movies - " + Inventory.size() + "in total:\n";
            for(int i = 0; i<Inventory.size(); i++){
                Movie y = Inventory.get(i).copyOf(); 
                if((y.getRating() == null)){
                    list += y.getTitle() + "\n";
                }
                else{
                list += y.getTitle() + ", Ave Rating: "+ df.format(y.getRating()) + "\n";
                }
            }
        }
        
        else{
            
            Collections.sort(Inventory);
            Collections.reverse(Inventory);

            ArrayList<Movie> x = new ArrayList<>(Inventory.subList(0, N));
            list = "All Movies - " + x.size() + "in total:\n";
            list += "Top " + N + " Rated Movies:\n";
            for(int i = 0; i<x.size(); i++){
                list += x.get(i).copyOf().getTitle() + ", Ave Rating: " + df.format(x.get(i).copyOf().getRating()) + "\n";
            }

        }
        return list;
    }
    
    public void clear() {
    	Inventory.clear();
    }

}
