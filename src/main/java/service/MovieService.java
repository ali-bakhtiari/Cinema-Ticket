package service;

import model.Film;
import repository.IMovieRepository;

import java.util.List;

public class MovieService implements IMovieService {
    private final IMovieRepository repository;

    public MovieService(IMovieRepository repository) {
        this.repository = repository;
        repository.save(new Film(1, "The Silence of the Lambs", 121, 22.5));
        repository.save(new Film(2, "leon", 110, 69.5));
    }

    @Override
    public List<Film> getAllFilms() {
        return repository.findAll();
    }

    @Override
    public Film getFilm(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean buyTicket(int id, int count) {
        Film film = repository.findById(id);
        if (film != null && film.hasEnoughTicket(count)) {
            film.reducingTicket(count);
            return true;
        }
        return false;
    }

    @Override
    public Film addFilm(Film film) {
        return repository.save(film);
    }

    @Override
    public boolean updateFilm(int id, Film film) {
        return repository.update(id, film);
    }

    @Override
    public void deleteFilm(int id) {
        repository.delete(id);
    }
}