import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reserva.MainApplication;
import reserva.reservas.entities.TOFilmeDisponivel;
import reserva.reservas.entities.TOReserva;
import reserva.reservas.service.ReservaFacade;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = MainApplication.class)
public class ReservaTest {

    @Autowired
    private ReservaFacade reservaFacade;

    @Test
    public void testCad1() {
        TOFilmeDisponivel to = new TOFilmeDisponivel();
        to.setDescricao("Peça XPTO");
        to.setNomeFilme("TESTE");
        to.setHorario("18:00");
        to.setQuantidade(20);
        TOFilmeDisponivel retorno =  reservaFacade.cadastrarFilme(to);
        assertNotNull(retorno);
        assertEquals(to, retorno);
    }

    @Test
    public void testCad2() {
        TOReserva reserva = new TOReserva();
        reserva.setQuantidade(2);
        reserva.setNome("Ana");
        reserva.setFilmeDisponivel("TESTE");
        TOReserva reservas =  reservaFacade.cadastrarReserva(reserva);
        assertNotNull(reservas);
        assertEquals(reserva, reservas);
    }
}
