/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/


/**
 * @author MaterialPOO
 * @version 20230424
 */


import java.time.LocalDate;


public class Abdominal extends Atividade {
    private String tipo;
    private int repeticoes;

    public Abdominal() {
        super();
        this.tipo = "";
        this.repeticoes = 0;
    }

    public Abdominal(String codigo, String descricao, LocalDate data, int duracao, String tipo, int repeticoes) {
        super(codigo, descricao, data, duracao);
        this.tipo = tipo;
        this.repeticoes = repeticoes;
    }

    public Abdominal(Abdominal outro) {
        super(outro);
        this.tipo = outro.getTipo();
        this.repeticoes = outro.getRepeticoes();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

   /**
    * Nota: a fórmula está diferente ao que é pedido no enunciado.
   */
    public double calorias(Utilizador u) {
        return getDuracao()*repeticoes*3/5*(1+1/u.getPeso());
    }


    public Atividade clone() {
        return new Abdominal(this);
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Abdominal abdominal = (Abdominal) o;
        return getRepeticoes() == abdominal.getRepeticoes() 
               && this.tipo.equals(abdominal.getTipo());
    }


    public String toString() {
        return "Abdominal{" +
                super.toString() +
                "tipo='" + tipo + '\'' +
                ", repeticoes=" + repeticoes +
                '}';
    }
}
