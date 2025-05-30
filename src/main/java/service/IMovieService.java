package service;
import model.Film;
import java.util.List;

public interface IMovieService {

        List<Film> getAllFilms();
        Film getFilm(int id);
        boolean buyTicket(int id, int count);
        Film addFilm(Film film);
        boolean updateFilm(int id, Film film);
        public void deleteFilm(int id);
    }
