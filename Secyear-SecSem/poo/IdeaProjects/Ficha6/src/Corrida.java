import java.net.CookieHandler;
import java.time.LocalDate;

public class Corrida extends Desporto {
    private int dist;
    private int altimetria;
    private String percurso;

    public Corrida() {
        super();
        Corrida corrida = new Corrida();
        this.dist = 0;
        this.altimetria = 0;
        this.percurso = "";
    }

    public Corrida(int dist, int altimetria, String percurso, int id, String descricao, LocalDate dataReal, int duracao) {
        super(id, descricao, dataReal, duracao);
        this.dist = dist;
        this.altimetria = altimetria;
        this.percurso = percurso;
    }

    public Corrida (Corrida corrida) {
        super(corrida);
        this.dist = corrida.getDist();
        this.altimetria = corrida.getAltimetria();
        this.percurso = corrida.getPercurso();
    }

    public int getDist() {
        return this.dist;
    }

    public int getAltimetria() {
        return this.altimetria;
    }

    public String getPercurso() {
        return this.percurso;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public void setAltimetria(int altimetria) {
        this.altimetria = altimetria;
    }

    public void setPercurso(String percurso) {
        this.percurso = percurso;
    }

    public Corrida clone() {
        return new Corrida(this);
    }
}
