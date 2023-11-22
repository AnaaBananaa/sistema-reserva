package reserva.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reserva.reservas.entities.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
