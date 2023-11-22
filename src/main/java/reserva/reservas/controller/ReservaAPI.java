package reserva.reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reserva.reservas.entities.TOPecas.TOPeca;
import reserva.reservas.entities.TOReserva;
import reserva.reservas.service.ReservaFacade;

import java.util.List;

@RestController
@RequestMapping(value = "/reserva", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservaAPI {

    @Autowired
    private ReservaFacade reservaFacade;

    @PostMapping("/cadastrar")
    @ResponseBody
    public TOReserva cadastrarReserva(@RequestBody TOReserva to){
        return reservaFacade.cadastrarReserva(to);
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<TOReserva> listarReservas(){
        return reservaFacade.listarReserva();
    }

    @GetMapping("/listarPecas")
    @ResponseBody
    public List<TOPeca> listarTeatros(){
        RestTemplate template = new RestTemplate();
        ResponseEntity<TOPeca[]> response = template.getForEntity("http://localhost:8080/teatro/listar", TOPeca[].class);
        return List.of(response.getBody());
    }


    @DeleteMapping("/deletar/{id}")
    @ResponseBody
    public String removerReserva(@PathVariable("id") Long id){
        return reservaFacade.removerReserva(id);
    }

}
