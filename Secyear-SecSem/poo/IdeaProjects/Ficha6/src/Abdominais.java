import java.time.LocalDate;

public class Abdominais extends Desporto{
    private String tipo;
    private int repeticoes;

    public Abdominais() {
        super();
        Abdominais abdominais = new Abdominais();
        this.tipo = "";
        this.repeticoes = 0;
    }

    public Abdominais(String tipo, int repeticoes, int id, String descricao, LocalDate dataReal, int duracao) {
        super(id, descricao, dataReal, duracao);
        this.tipo = tipo;
        this.repeticoes = repeticoes;
    }

    public Abdominais (Abdominais abdominais) {
        super(abdominais);
        this.tipo = getTipo();
        this.repeticoes = getRepeticoes();
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getRepeticoes() {
        return this.repeticoes;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public Abdominais clone() {
        return  new Abdominais(this);
    }
}