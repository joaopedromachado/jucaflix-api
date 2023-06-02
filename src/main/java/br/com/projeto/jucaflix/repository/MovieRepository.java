package br.com.projeto.jucaflix.repository;

import br.com.projeto.jucaflix.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    Optional<Movie> findByTitleLike(String title);
    List<Movie> findAllByRatingGreaterThanEqual(double rating);
    List<Movie> findAllByYearGreaterThanEqual(Integer year);
}
