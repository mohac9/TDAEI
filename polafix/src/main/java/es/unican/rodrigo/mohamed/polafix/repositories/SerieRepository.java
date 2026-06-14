package es.unican.rodrigo.mohamed.polafix.repositories;

import es.unican.rodrigo.mohamed.polafix.domain.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SerieRepository extends JpaRepository<Serie, String> {
}