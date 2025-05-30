package repository;
import model.Film;
import java.util.List;

public interface IMovieRepository {

        List<Film> findAll();
        Film findById(int id);
        Film save(Film film);
        boolean update(int id, Film film);
        public void delete(int id);
    }