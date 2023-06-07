package br.com.projeto.jucaflix.controller.response;

import br.com.projeto.jucaflix.model.dto.Genre;
import br.com.projeto.jucaflix.model.dto.Spoiler;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MovieResponse {

    private String id;
    private String title;
    private String director;
    private Genre genre;
    private Integer year;
    private double rating;
    private List<Spoiler> spoilers;
    private LocalDateTime created;
    private LocalDateTime edited;
    private String url;

}
