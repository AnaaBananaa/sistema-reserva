package reserva.reservas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.reservas.entities.Reserva;
import reserva.reservas.entities.TOReserva;
import reserva.reservas.repository.ReservaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaFacade {

    @Autowired
    private ReservaRepository repository;

    public TOReserva cadastrarReserva(TOReserva to){
        Reserva reserva = new Reserva();
        reserva.setFilme(to.getFilme());
        reserva.setNome(to.getNome());
        repository.save(reserva);
        to.setId(reserva.getId());
        return to;
    }

    private TOReserva converter (Reserva teatro){
        TOReserva to = new TOReserva();
        to.setId(teatro.getId());
        to.setNome(teatro.getNome());
        to.setFilme(teatro.getFilme());
        return to;
    }

    public List<TOReserva> listarReserva(){
        return repository.findAll().stream().map(this::converter).collect(Collectors.toList());
    }

    public String removerReserva(Long id){
        repository.deleteById(id);
        return "Reserva removida com sucesso!";
    }

}
