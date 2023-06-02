package br.com.projeto.jucaflix.service;

import br.com.projeto.jucaflix.controller.request.MovieRequest;
import br.com.projeto.jucaflix.controller.response.MovieResponse;
import br.com.projeto.jucaflix.model.Movie;
import br.com.projeto.jucaflix.mapper.MovieMapper;
import br.com.projeto.jucaflix.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
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

    public MovieResponse getMovieById(String id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme id [" + id + "] não encontrado."));

        return MovieMapper.movieToResponse(movie);
    }

    public MovieResponse getMovieByTitle(String title) {
        Movie movie = movieRepository.findByTitleLike(title)
                .orElseThrow(() -> new RuntimeException("O título [" + title + "] não existe."));

        return MovieMapper.movieToResponse(movie);
    }

    public MovieResponse saveMovie(MovieRequest request) {
        Movie movie = MovieMapper.requestToMovie(request);

        Movie movieSaved = movieRepository.save(movie);

        return MovieMapper.movieToResponse(movieSaved);
    }

    public void deleteMovieById(String id) {
        movieRepository.deleteById(id);
    }

    public MovieResponse updateMovieById(String id, MovieRequest request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme ID" + id + " não encontrado."));

        MovieMapper.requestToUpdateMovie(request, movie);

        Movie movieSaved = movieRepository.save(movie);

        return MovieMapper.movieToResponse(movieSaved);
    }

    public MovieResponse updateMovieSpoilers(String id, MovieRequest request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme ID" + id + " não encontrado."));

        MovieMapper.requestToUpdateMovieSpoilers(request, movie);

        Movie movieSaved = movieRepository.save(movie);

        return MovieMapper.movieToResponse(movieSaved);
    }

}
