public class Funcionario {

	private int identificador;
	private String nome;

	public Funcionario(int identificador, String nome) {
		this.identificador = identificador;
		this.nome = nome;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public void initTrabalho() {
		// TODO - implement Funcionario_.initTrabalho
		throw new UnsupportedOperationException();
	}

	public void terminarTrabalho() {
		// TODO - implement Funcionario_.terminarTrabalho
		throw new UnsupportedOperationException();
	}

}