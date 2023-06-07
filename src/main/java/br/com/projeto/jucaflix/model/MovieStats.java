package br.com.projeto.jucaflix.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "statistics")
public class MovieStats {

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
