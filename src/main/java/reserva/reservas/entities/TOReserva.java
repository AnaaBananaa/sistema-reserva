package reserva.reservas.entities;

public class TOReserva {

    private Long id;
    private String nome;
    private String filmeDisponivel;
    private int quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getFilmeDisponivel() {
        return filmeDisponivel;
    }
    public void setFilmeDisponivel(String filmeDisponivel) {
        this.filmeDisponivel = filmeDisponivel;
    }
}
