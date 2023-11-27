import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reserva.MainApplication;
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
    public void testUserService() {
        List<TOReserva> reservas =  reservaFacade.listarReserva();
        assertNotNull(reservas);
        assertEquals(new ArrayList<>(), reservas);
    }
}
