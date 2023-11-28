package reserva.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reserva.reservas.entities.FilmeDisponivel;
import reserva.reservas.entities.Reserva;

import java.util.Optional;

@Repository
public interface FilmeRepository extends JpaRepository<FilmeDisponivel, Long> {
    @Query("SELECT f FROM FilmeDisponivel f WHERE f.nomeFilme = ?1")
    public FilmeDisponivel findByNomeFilme(String nomeFilme);
}
