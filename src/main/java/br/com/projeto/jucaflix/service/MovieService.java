package br.com.projeto.jucaflix.service;

import br.com.projeto.jucaflix.controller.request.MovieRequest;
import br.com.projeto.jucaflix.controller.response.MovieResponse;
import br.com.projeto.jucaflix.mapper.MovieMapper;
import br.com.projeto.jucaflix.model.Movie;
import br.com.projeto.jucaflix.model.dto.Genre;
import br.com.projeto.jucaflix.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<MovieResponse> getMovies() {
        return movieRepository.findAll()
                .stream()
                .map(MovieMapper::movieToResponse)
                .collect(Collectors.toList());
    }

    public List<MovieResponse> getMoviesRatedGreaterThanEqual(double rating) {
        return movieRepository.findAllByRatingGreaterThanEqual(rating).stream()
                .map(MovieMapper::movieToResponse)
                .collect(Collectors.toList());
    }

    public List<MovieResponse> getMoviesByYear(Integer year) {
        return movieRepository.findAllByYearGreaterThanEqual(year).stream()
                .map(MovieMapper::movieToResponse)
                .collect(Collectors.toList());
    }

    public List<MovieResponse> getMoviesByYearEquals(Integer year) {
        return movieRepository.findAllByYearEquals(year).stream()
                .map(MovieMapper::movieToResponse)
                .collect(Collectors.toList());
    }

    public List<MovieResponse> getMoviesOrderByRatingAndYear(Integer year, Double rating) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getYear().equals(year) && movie.getRating() <= rating)
                .map(MovieMapper::movieToResponse)
                .collect(Collectors.toList());
    }

    public MovieResponse getMovieById(String id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme id [" + id + "] não encontrado."));

        return MovieMapper.movieToResponse(movie);
    }

    public ResponseEntity<MovieResponse> getMovieByTitle(String title) {
        Movie movie = movieRepository.findByTitleLike(title)
                .orElseThrow(() -> new RuntimeException("O título [" + title + "] não existe."));

        log.info("Buscando o filme com título: " + title);


        return ResponseEntity.status(HttpStatus.FOUND).body(MovieMapper.movieToResponse(movie));
    }

    public List<MovieResponse> getMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre().equals(genre))
                .map(MovieMapper::movieToResponse)
                .collect(Collectors.toList());
    }

    public MovieResponse saveMovie(MovieRequest request) {
        Movie movie = MovieMapper.requestToMovie(request);

        return MovieMapper.movieToResponse(movieRepository.save(movie));
    }

    public void saveAllMovies(List<MovieRequest> request) {
        List<Movie> movies = MovieMapper.requestListToMovie(request);

        movieRepository.saveAll(movies);
    }

    public void deleteMovieById(String id) {
        movieRepository.deleteById(id);
    }

    public MovieResponse deleteSpoilersById(String id, int index) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme ID" + id + " não encontrado."));

        movie.getSpoilers().remove(index);

        Movie movieSaved = movieRepository.save(movie);

        return MovieMapper.movieToResponse(movieSaved);
    }

    public MovieResponse insertMoviesById(String id, MovieRequest request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme ID" + id + " não encontrado."));

        MovieMapper.requestToUpdateMovie(request, movie);

        return MovieMapper.movieToResponse(movieRepository.save(movie));
    }

    public MovieResponse insertSpoilerEntity(String id, MovieRequest request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme ID" + id + " não encontrado."));

        MovieMapper.requestToInsertSpoilers(request, movie);

        return MovieMapper.movieToResponse(movieRepository.save(movie));
    }

    public MovieResponse updateSpoilerEntity(String id, int index, MovieRequest request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme ID" + id + " não encontrado."));

        movie.getSpoilers().get(index).setDescription(request.getSpoilers().toString());

        return MovieMapper.movieToResponse(movieRepository.save(movie));
    }
}
