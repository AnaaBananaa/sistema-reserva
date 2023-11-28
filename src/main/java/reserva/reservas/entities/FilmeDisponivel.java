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

    private String nomeFilme;

    private String descricao;

    private String horario;

    public FilmeDisponivel() {
    }

    public FilmeDisponivel(Long id, int quantidade, String nomeFilme, String descricao) {
        this.id = id;
        this.quantidade = quantidade;
        this.nomeFilme = nomeFilme;
        this.descricao = descricao;
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

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
