package br.com.projeto.jucaflix.repository;

import br.com.projeto.jucaflix.model.MovieStats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieStatsRepository extends MongoRepository<MovieStats, String> {
}
