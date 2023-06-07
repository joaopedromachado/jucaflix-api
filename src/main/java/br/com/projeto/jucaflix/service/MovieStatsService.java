package br.com.projeto.jucaflix.service;

import br.com.projeto.jucaflix.mapper.MovieStatsMapper;
import br.com.projeto.jucaflix.model.MovieStats;
import br.com.projeto.jucaflix.model.dto.Genre;
import br.com.projeto.jucaflix.model.dto.MovieStatsDto;
import br.com.projeto.jucaflix.repository.MovieRepository;
import br.com.projeto.jucaflix.repository.MovieStatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieStatsService {

    private final MovieService service;
    private final MovieRepository movieRepository;
    private final MovieStatsRepository statsRepository;

    public MovieStatsDto getCountMovieStats() {
        Integer count = movieRepository.findAll().size();
        MovieStats movieStats = new MovieStats();
        movieStats.setCountMovies(count);
        return MovieStatsMapper.movieStatsToResponse(statsRepository.save(movieStats));
    }

    public MovieStatsDto getCountGenreMovies() {
        Integer count = service.getMoviesByGenre(Genre.ACTION).size();
        MovieStats movieStats = new MovieStats();
        movieStats.setCountActionMovies(count);
        return MovieStatsMapper.movieStatsToResponse(statsRepository.save(movieStats));
    }
}
