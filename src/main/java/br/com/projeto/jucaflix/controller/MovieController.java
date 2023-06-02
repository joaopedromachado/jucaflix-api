package br.com.projeto.jucaflix.controller;

import br.com.projeto.jucaflix.controller.request.MovieRequest;
import br.com.projeto.jucaflix.controller.response.MovieResponse;
import br.com.projeto.jucaflix.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/movies")
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
    @GetMapping("/rate/{rating}")
    public List<MovieResponse> getMoviesRatedGreaterThanEqual(@PathVariable double rating) {
        return movieService.getMoviesRatedGreaterThanEqual(rating);
    }

    @ApiOperation(value = "Obter filme por título", response = MovieResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filme encontrado"),
            @ApiResponse(code = 404, message = "Filme não encontrado")
    })
    @GetMapping("/titulo/{title}")
    public MovieResponse getMovieByTitle(@PathVariable String title) {
        return movieService.getMovieByTitle(title);
    }

    @ApiOperation(value = "Obter filmes por ano", response = MovieResponse.class, responseContainer = "List")
    @GetMapping("/ano/{year}")
    public List<MovieResponse> getMoviesByYear(@PathVariable Integer year) {
        return movieService.getMoviesByYear(year);
    }

    @ApiOperation(value = "Salvar um novo filme", response = MovieResponse.class)
    @PostMapping
    public MovieResponse savePlanet(@RequestBody MovieRequest request) {
        return movieService.saveMovie(request);
    }

    @ApiOperation(value = "Excluir filme por ID")
    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable String id) {
        movieService.deleteMovieById(id);
        log.info("Filme removido!");
    }

    @ApiOperation(value = "Atualizar filme por ID", response = MovieResponse.class)
    @PutMapping("/{id}")
    public MovieResponse updateMovieById(@PathVariable String id, @RequestBody MovieRequest request){
        return movieService.updateMovieById(id, request);
    }

    @PutMapping("/spoilers/{id}")
    public MovieResponse updateMovieSpoilers(@PathVariable String id, @RequestBody MovieRequest request) {
        return movieService.updateMovieSpoilers(id, request);
    }

}
