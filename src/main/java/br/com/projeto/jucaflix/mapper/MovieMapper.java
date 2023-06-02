package br.com.projeto.jucaflix.mapper;

import br.com.projeto.jucaflix.controller.request.MovieRequest;
import br.com.projeto.jucaflix.controller.response.MovieResponse;
import br.com.projeto.jucaflix.model.Movie;

import java.time.LocalDateTime;

public class MovieMapper {
    public static Movie requestToMovie(MovieRequest request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setDirector(request.getDirector());
        movie.setGenre(request.getGenre());
        movie.setYear(request.getYear());
        movie.setRating(request.getRating());
        movie.setMovieSpoilers(request.getMovieSpoilers());
        return movie;
    }

    public static MovieResponse movieToResponse(Movie movie){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setDirector(movie.getDirector());
        movieResponse.setGenre(movie.getGenre());
        movieResponse.setYear(movie.getYear());
        movieResponse.setRating(movie.getRating());
        movieResponse.setMovieSpoilers(movie.getMovieSpoilers());
        movieResponse.setCreated(LocalDateTime.now());
        movieResponse.setEdited(LocalDateTime.now());
        movieResponse.setUrl(getMovieUrl(movie.getId()));
        return movieResponse;
    }

    public static void requestToUpdateMovie(MovieRequest request, Movie movie) {
        movie.setTitle(request.getTitle());
        movie.setDirector(request.getDirector());
        movie.setGenre(request.getGenre());
        movie.setRating(request.getRating());
        movie.setMovieSpoilers(request.getMovieSpoilers());
        movie.setEdited(LocalDateTime.now());
    }

    public static void requestToUpdateMovieSpoilers(MovieRequest request, Movie movie) {
        movie.setMovieSpoilers(request.getMovieSpoilers());
        movie.setEdited(LocalDateTime.now());
    }

    public static String getMovieUrl(String id) {
        return "http://localhost:8080/v1/movies/" + id;
    }

}
