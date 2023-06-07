package br.com.projeto.jucaflix.mapper;

import br.com.projeto.jucaflix.controller.request.MovieRequest;
import br.com.projeto.jucaflix.controller.response.MovieResponse;
import br.com.projeto.jucaflix.model.Movie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MovieMapper {
    public static Movie requestToMovie(MovieRequest request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setDirector(request.getDirector());
        movie.setGenre(request.getGenre());
        movie.setYear(request.getYear());
        movie.setRating(request.getRating());
        movie.setSpoilers(request.getSpoilers());
        movie.setCreated(LocalDateTime.now());
        return movie;
    }

    public static List<Movie> requestListToMovie(List<MovieRequest> requests) {
        return requests.stream()
                .map(request -> {
                    Movie movie = new Movie();
                    movie.setTitle(request.getTitle());
                    movie.setDirector(request.getDirector());
                    movie.setGenre(request.getGenre());
                    movie.setYear(request.getYear());
                    movie.setRating(request.getRating());
                    movie.setSpoilers(request.getSpoilers());
                    movie.setCreated(LocalDateTime.now());
                    return movie;
        }).collect(Collectors.toList());
    }

    public static MovieResponse movieToResponse(Movie movie){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setDirector(movie.getDirector());
        movieResponse.setGenre(movie.getGenre());
        movieResponse.setYear(movie.getYear());
        movieResponse.setRating(movie.getRating());
        movieResponse.setSpoilers(movie.getSpoilers());
        movieResponse.setCreated(LocalDateTime.now());
        movieResponse.setEdited(movie.getEdited());
        movieResponse.setUrl(getMovieUrl(movie));
        return movieResponse;
    }

    public static void requestToUpdateMovie(MovieRequest request, Movie movie) {
        movie.setTitle(request.getTitle());
        movie.setEdited(LocalDateTime.now());
    }

    public static void requestToInsertSpoilers(MovieRequest request, Movie movie) {
        movie.getSpoilers().addAll(request.getSpoilers());
        movie.setEdited(LocalDateTime.now());
    }

    public static void requestToUpdateSpoilers(MovieRequest request, Movie movie) {
        movie.setSpoilers(request.getSpoilers());
        movie.setEdited(LocalDateTime.now());
    }

    public static String getMovieUrl(Movie movie) {
        return "http://localhost:8080/v1/films/" + movie.getId();
    }

}
