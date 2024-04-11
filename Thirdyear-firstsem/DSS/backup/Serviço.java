
public abstract class Serviço{

	private long tempoEsperado;
	private String nome;
	private Boolean estado;
	private int tipoServico;

	public Serviço(long tempoEsperado, String nome, Boolean estado, int tipoServico) {
		this.tempoEsperado = tempoEsperado;
		this.nome = nome;
		this.estado = estado;
		this.tipoServico = tipoServico;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Serviço{" +
				"tempoEsperado=" + tempoEsperado +
				", nome='" + nome + '\'' +
				", estado=" + estado +
				", tipoServiço=" + tipoServico +
				'}';
	}
}