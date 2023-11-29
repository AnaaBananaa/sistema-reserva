package reserva.reservas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reserva.reservas.entities.FilmeDisponivel;
import reserva.reservas.entities.Reserva;
import reserva.reservas.entities.TOFilmeDisponivel;
import reserva.reservas.entities.TOReserva;
import reserva.reservas.repository.FilmeRepository;
import reserva.reservas.repository.ReservaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaFacade {

    @Autowired
    private ReservaRepository repository;
    @Autowired
    private FilmeRepository repositoryfilm;

    public TOReserva cadastrarReserva(TOReserva to){
        Reserva reserva = new Reserva();
        reserva.setFilmeDisponivel(to.getFilmeDisponivel());
        reserva.setNome(to.getNome());
        reserva.setQuantidade(to.getQuantidade());
        FilmeDisponivel filme = repositoryfilm.findByNomeFilme(to.getFilmeDisponivel()).get(0);
        filme.setQuantidade(filme.getQuantidade() - to.getQuantidade());
        repositoryfilm.save(filme);
        repository.save(reserva);
        to.setId(reserva.getId());
        return to;
    }

    public FilmeDisponivel encontrarFilme(String nome){
        List<FilmeDisponivel> filmes = repositoryfilm.findByNomeFilme(nome);
        return filmes.size() > 1 ? filmes.get(0) : null;
    }

    private TOReserva converter (Reserva teatro){
        TOReserva to = new TOReserva();
        to.setId(teatro.getId());
        to.setNome(teatro.getNome());
        to.setFilmeDisponivel(teatro.getFilmeDisponivel());
        to.setQuantidade(teatro.getQuantidade());
        return to;
    }

    public TOFilmeDisponivel cadastrarFilme(TOFilmeDisponivel to){
        repositoryfilm.save(converterFilme(to));
        return to;
    }

    private FilmeDisponivel converterFilme (TOFilmeDisponivel to){
        FilmeDisponivel filme = new FilmeDisponivel();
        filme.setId(to.getId());
        filme.setNomeFilme(to.getNomeFilme());
        filme.setDescricao(to.getDescricao());
        filme.setQuantidade(to.getQuantidade());
        filme.setHorario(to.getHorario());
        return filme;
    }

    private TOFilmeDisponivel converterTOFilme (FilmeDisponivel filme){
        TOFilmeDisponivel to = new TOFilmeDisponivel();
        to.setId(filme.getId());
        to.setNomeFilme(filme.getNomeFilme());
        to.setDescricao(filme.getDescricao());
        to.setQuantidade(filme.getQuantidade());
        to.setHorario(filme.getHorario());
        return to;
    }

    public List<TOReserva> listarReserva(){
        return repository.findAll().stream().map(this::converter).collect(Collectors.toList());
    }

    public List<TOFilmeDisponivel> listarFilmes(){
        return repositoryfilm.findAll().stream().map(this::converterTOFilme).collect(Collectors.toList());
    }

    public String removerReserva(Long id){
        repository.deleteById(id);
        return "Reserva removida com sucesso!";
    }

}
