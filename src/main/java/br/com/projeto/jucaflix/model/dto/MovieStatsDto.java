package br.com.projeto.jucaflix.model.dto;

import lombok.Data;

@Data
public class MovieStatsDto {
    private Integer countMovies;
    private Integer countActionMovies;
    private Integer countHorrorMovies;
    private Integer countComedyMovies;
    private Integer countDramaMovies;
    private Integer countFantasyMovies;
    private Integer countRomanceMovies;
    private Integer countCrimeMovies;
    private Double movieRatingMedia;
}
