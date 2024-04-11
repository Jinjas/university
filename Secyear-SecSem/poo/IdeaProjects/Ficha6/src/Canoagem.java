import java.time.LocalDate;

public class Canoagem extends Desporto {
    private String embarcacao;
    private int vento;
    private String direcaoVento;
    private int dist;
    private int voltas;

    public Canoagem() {
        super();
        Canoagem canoagem = new Canoagem();
        this.embarcacao = "";
        this.vento = 0;
        this.direcaoVento = "";
        this.dist = 0;
        this.voltas = 0;
    }

    public Canoagem(String embarcacao, int vento, String direcaoVento, int dist, int voltas, int id, String descricao, LocalDate dataReal, int duracao){
        super(id, descricao, dataReal, duracao);
        this.embarcacao = embarcacao;
        this.vento = vento;
        this.direcaoVento = direcaoVento;
        this.dist = dist;
        this.voltas = voltas;
    }

    public Canoagem (Canoagem canoagem) {
        super(canoagem);
        this.embarcacao = canoagem.getEmbarcacao();
        this.vento = canoagem.getVento();
        this.direcaoVento = canoagem.getDirecaoVento();
        this.dist = canoagem.getDist();
        this.voltas = canoagem.getVoltas();
    }

    public String getEmbarcacao() {
        return this.embarcacao;
    }

    public int getVento() {
        return this.vento;
    }

    public String getDirecaoVento() {
        return this.direcaoVento;
    }

    public int getVoltas() {
        return this.voltas;
    }

    public int getDist() {
        return this.dist;
    }

    public void setEmbarcacao(String embarcacao) {
        this.embarcacao = embarcacao;
    }

    public void setVento(int vento) {
        this.vento = vento;
    }

    public void setDirecaoVento(String direcaoVento) {
        this.direcaoVento = direcaoVento;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public void setVoltas(int voltas) {
        this.voltas = voltas;
    }

    public Canoagem clone() {
        return new Canoagem(this);
    }

}