import java.awt.*;
import java.time.LocalDate;

public class Desporto {
    private int id;
    private String descricao;
    private LocalDate dataReal;
    private int duracao;

    public Desporto() {
        Desporto desporto = new Desporto();
        this.id = 0;
        this.descricao = "";
        this.dataReal = LocalDate.now();
        this.duracao = 0;
    }

    public Desporto(int id, String descricao, LocalDate dataReal, int duracao) {
        this.id = id;
        this.descricao = descricao;
        this.dataReal = dataReal;
        this.duracao = duracao;

    }

    public Desporto(Desporto desporto) {
        this.id = desporto.getId();
        this.descricao = desporto.getDescricao();
        this.dataReal = desporto.getDataReal();
        this.duracao = desporto.getDuracao();
    }

    public int getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public LocalDate getDataReal() {
        return this.dataReal;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataReal(LocalDate dataReal) {
        this.dataReal = dataReal;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Desporto clone() {
        return new Desporto(this);
    }


}