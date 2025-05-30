//package movie;
//
//import model.Film;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MovieLogic {
//    private List<Film> films;
//    public MovieLogic(){
//        films = new ArrayList<>();
//        films.add(new Film("The Silence of the Lambs",121,22.5));
//        films.add(new Film("leon",110,69.5));
//        films.add(new Film("Matrix",128,55.5));
//        films.add(new Film("MaxPain",133,58.5));
//    }
//    public List<Film> getAllFilms(){
//        return films;
//    }
//    public Film getChoosenFilm (int index){
//        if (index < 0 || index >= films.size()) {
//            return null;
//        }
//        return films.get(index);
//    }
//    public boolean buyingTicket(Film film,int cont){
//        if (film.hasEnoughTicket(cont)){
//            film.reducingTicket(cont);
//            return true;
//        }
//        return false;
//    }
//    }
//
