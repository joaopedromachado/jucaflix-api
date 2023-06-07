package br.com.projeto.jucaflix.controller;

import br.com.projeto.jucaflix.controller.request.MovieRequest;
import br.com.projeto.jucaflix.controller.response.MovieResponse;
import br.com.projeto.jucaflix.model.dto.Genre;
import br.com.projeto.jucaflix.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/films")
@Api(value = "Movie", tags = "Filmes")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @ApiOperation(value = "Obter todos os filmes", response = MovieResponse.class, responseContainer = "List")
    @GetMapping
    public List<MovieResponse> getMovies() {
        return movieService.getMovies();
    }

    @ApiOperation(value = "Obter filme por ID", response = MovieResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filme encontrado"),
            @ApiResponse(code = 404, message = "Filme não encontrado")
    })
    @GetMapping("/{id}")
    public MovieResponse getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @ApiOperation(value = "Obter filmes com classificação maior ou igual a uma determinada nota", response = MovieResponse.class, responseContainer = "List")
    @GetMapping("/rating/{rating}")
    public List<MovieResponse> getMoviesRatedGreaterThanEqual(@PathVariable double rating) {
        return movieService.getMoviesRatedGreaterThanEqual(rating);
    }


    @ApiOperation(value = "Obter filme por título", response = MovieResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filme encontrado"),
            @ApiResponse(code = 404, message = "Filme não encontrado")
    })
    @GetMapping("/title/{title}")
    public ResponseEntity<MovieResponse> getMovieByTitle(@PathVariable String title) {
        return movieService.getMovieByTitle(title);
    }

    @ApiOperation(value = "Obter filmes por ano", response = MovieResponse.class, responseContainer = "List")
    @GetMapping("/year/{year}")
    public List<MovieResponse> getMoviesByYear(@PathVariable Integer year) {
        return movieService.getMoviesByYear(year);
    }

    @GetMapping("/year/equals/{year}")
    public List<MovieResponse> getMoviesByYearEquals(@PathVariable Integer year) {
        return movieService.getMoviesByYearEquals(year);
    }

    @GetMapping("/genre/{genre}")
    public List<MovieResponse> getMoviesByGenre(@PathVariable Genre genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("/ordered/{year}/{rating}")
    public List<MovieResponse> getMoviesOrderByRatingAndYear(@PathVariable Integer year, @PathVariable double rating) {
        return movieService.getMoviesOrderByRatingAndYear(year, rating);
    }

    @ApiOperation(value = "Salvar um novo filme", response = MovieResponse.class)
    @PostMapping
    public MovieResponse saveMovie(@RequestBody MovieRequest request) {
        return movieService.saveMovie(request);
    }

    @PostMapping("/collection/")
    public void saveAllMovies(@RequestBody List<MovieRequest> requests) {
        movieService.saveAllMovies(requests);
    }

    @ApiOperation(value = "Excluir filme por ID")
    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable String id) {
        movieService.deleteMovieById(id);
        log.info("Filme removido!");
    }

    @ApiOperation(value = "Excluir filme pelo índice e ID")
    @DeleteMapping("/spoilers/{index}/{id}")
    public MovieResponse deleteSpoilersById(@PathVariable int index, @PathVariable  String id) {
        return movieService.deleteSpoilersById(id, index);
    }

    @ApiOperation(value = "Adicionar filmes por ID", response = MovieResponse.class)
    @PutMapping("/{id}")
    public MovieResponse insertMoviesById(@PathVariable String id, @RequestBody MovieRequest request){
        return movieService.insertMoviesById(id, request);
    }

    @ApiOperation(value = "Adicionar spoilers do filme por id", response = MovieResponse.class)
    @PutMapping("/spoilers/{id}")
    public MovieResponse insertSpoilerEntity(@PathVariable String id, @RequestBody MovieRequest request) {
        return movieService.insertSpoilerEntity(id, request);
    }

    @PutMapping("/spoilers/{index}/{id}")
    public MovieResponse updateSpoilerEntity(@PathVariable int index, @PathVariable String id, @RequestBody MovieRequest request) {
        return movieService.updateSpoilerEntity(id, index, request);
    }

}
