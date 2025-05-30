package repository;

import model.Film;

import java.util.*;

public class MovieRepository implements IMovieRepository {
    private final Map<Integer, Film> films = new HashMap<>();
    private int nextId = 1;

    @Override
    public List<Film> findAll() {
        return new ArrayList<>(films.values());
    }

    @Override
    public Film findById(int id) {
        return films.get(id);
    }

    @Override
    public Film save(Film film) {
        film.setId(nextId++);
        films.put(film.getId(), film);
        return film;
    }

    @Override
    public boolean update(int id, Film film) {
        if (films.containsKey(id)) {
            film.setId(id);
            films.put(id, film);
            return true;
        }
        return false;
    }

    @Override
    public void delete(int id) {
        films.remove(id);
    }
}
