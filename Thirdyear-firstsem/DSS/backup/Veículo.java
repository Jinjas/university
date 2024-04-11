import java.util.*;

public class Veículo {

	private Ficha ficha;
	private int idVeiculo;
	private String matricula;
	private Categoria tipo;


	public Veículo(int idVeiculo, String matricula, Categoria tipo) {
		this.ficha = new Ficha();
		this.idVeiculo = idVeiculo;
		this.matricula = matricula;
		this.tipo = tipo;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public Categoria getTipo() {
		return tipo;
	}

	public void setTipo(Categoria tipo) {
		this.tipo = tipo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		Veículo veículo = (Veículo) object;
		return idVeiculo == veículo.idVeiculo && java.util.Objects.equals(ficha, veículo.ficha) && java.util.Objects.equals(matricula, veículo.matricula);
	}

	public int hashCode() {
		return java.util.Objects.hash(super.hashCode(), ficha, idVeiculo, matricula, tipo);
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Veículo{" +
				"ficha=" + ficha +
				", idVeiculo=" + idVeiculo +
				", matricula='" + matricula + '\'' +
				'}';
	}

	/**
	 * 
	 * @param servico
	 */
	public void adicionarServico(Serviço servico) {
		this.ficha.addServico(servico);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nome
	 * @param estado
	 */
	public void atualizarServico(int nome, Boolean estado) {
		// TODO - implement Veículo_.atualizarServiço
		throw new UnsupportedOperationException();
	}

}