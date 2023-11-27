package reserva.reservas.entities;

import javax.persistence.*;

@Entity
@Table(name = "filme_disponivel")
public class FilmeDisponivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private int quantidade;
    @ManyToOne
    private Reserva reserva;

    public FilmeDisponivel(int quantidade, Reserva reserva) {
        this.quantidade = quantidade;
        this.reserva = reserva;
    }

    public FilmeDisponivel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
