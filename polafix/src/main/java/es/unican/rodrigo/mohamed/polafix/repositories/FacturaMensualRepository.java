package es.unican.rodrigo.mohamed.polafix.repositories;

import es.unican.rodrigo.mohamed.polafix.domain.FacturaMensual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FacturaMensualRepository extends JpaRepository<FacturaMensual, String> {
}