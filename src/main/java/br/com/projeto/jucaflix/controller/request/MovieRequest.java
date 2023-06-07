package br.com.projeto.jucaflix.controller.request;

import br.com.projeto.jucaflix.model.dto.Genre;
import br.com.projeto.jucaflix.model.dto.Spoiler;
import com.fasterxml.jackson.annotation.JsonAlias;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MovieRequest {

    @NotBlank(message = "O valor deste atributo não pode ficar em branco.")
    private String title;
    @NotBlank(message = "O valor deste atributo não pode ficar em branco.")
    @JsonAlias("diretor")
    private String director;
    @NotNull(message = "O valor deste atributo não pode ser nulo.")
    private Genre genre;
    @NotNull
    private Integer year;
    @NotNull
    private double rating;
    private List<Spoiler> spoilers;

    public MovieRequest(String title, String director, Genre genre, Integer year, double rating) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }
    public MovieRequest(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Spoiler> getSpoilers() {
        return spoilers;
    }

}
