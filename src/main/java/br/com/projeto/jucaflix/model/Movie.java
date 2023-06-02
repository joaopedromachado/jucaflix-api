package br.com.projeto.jucaflix.model;

import br.com.projeto.jucaflix.model.dto.Genre;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movies")
@ApiModel(description = "Entidade do projeto Jucaflix")
public class Movie {
    @Id
    @ApiModelProperty(value = "ID do filme", example = "1")
    private String id;

    @ApiModelProperty(value = "Título do filme", example = "Matrix")
    private String title;

    @ApiModelProperty(value = "Diretor do filme", example = "Lana Wachowski")
    private String director;

    @ApiModelProperty(value = "Gênero do filme", example = "Ação")
    private Genre genre;

    @ApiModelProperty(value = "Ano de lançamento do filme", example = "1999")
    private Integer year;

    @ApiModelProperty(value = "Classificação do filme", example = "8.7")
    private double rating;

    @ApiModelProperty(value = "Spoilers do filme")
    private List<String> movieSpoilers;

    @ApiModelProperty(value = "Data de criação do filme")
    private LocalDateTime created;

    @ApiModelProperty(value = "Data de edição do filme")
    private LocalDateTime edited;

    @ApiModelProperty(value = "URL do filme")
    private String url;
}

