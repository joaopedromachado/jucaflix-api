package br.com.projeto.jucaflix.mapper;

import br.com.projeto.jucaflix.model.MovieStats;
import br.com.projeto.jucaflix.model.dto.MovieStatsDto;

public class MovieStatsMapper {

    public static MovieStatsDto movieStatsToResponse (MovieStats movieStats) {
        MovieStatsDto movieStatsDto = new MovieStatsDto();
        movieStatsDto.setCountMovies(movieStats.getCountMovies());
        movieStatsDto.setCountComedyMovies(movieStats.getCountComedyMovies());
        movieStatsDto.setCountFantasyMovies(movieStats.getCountFantasyMovies());
        movieStatsDto.setCountActionMovies(movieStats.getCountActionMovies());
        movieStatsDto.setCountHorrorMovies(movieStats.getCountHorrorMovies());
        movieStatsDto.setCountCrimeMovies(movieStats.getCountCrimeMovies());
        movieStatsDto.setCountRomanceMovies(movieStats.getCountRomanceMovies());
        movieStatsDto.setMovieRatingMedia(movieStats.getMovieRatingMedia());
        return movieStatsDto;
    }
}
