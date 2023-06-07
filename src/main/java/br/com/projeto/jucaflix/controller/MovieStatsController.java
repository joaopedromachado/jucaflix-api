package br.com.projeto.jucaflix.controller;

import br.com.projeto.jucaflix.model.dto.MovieStatsDto;
import br.com.projeto.jucaflix.service.MovieStatsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/films/statistics/")
@AllArgsConstructor
public class MovieStatsController {

    private final MovieStatsService statsService;

    @GetMapping("/count/")
    public MovieStatsDto getCountMovieStats() {
        return statsService.getCountMovieStats();
    }

    @GetMapping("/count/movies/genre/")
    public MovieStatsDto getCountGenreMovies() {
        return statsService.getCountGenreMovies();
    }
}
