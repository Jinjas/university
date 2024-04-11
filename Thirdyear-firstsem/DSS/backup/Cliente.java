import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cliente {

	private String nome;
	private int nif;
	private String morada;
	private int voucher;
	private String email;
	private int telefone;
	private int id;
	private HashMap<Integer,Veículo> veiculosP;

	public Cliente(String nome, int nif, String morada, int voucher, String email, int telefone, int id) {
		this.nome = nome;
		this.nif = nif;
		this.morada = morada;
		this.voucher = voucher;
		this.email = email;
		this.telefone = telefone;
		this.id = id;
		this.veiculosP = new HashMap<>();
	}



	public String getEmail() {
		return email;
	}


	public int getId() {
		return id;
	}



	@java.lang.Override
	public java.lang.String toString() {
		return "Cliente{" +
				"nome='" + nome + '\'' +
				", nif=" + nif +
				", morada='" + morada + '\'' +
				", voucher=" + voucher +
				", email='" + email + '\'' +
				", telefone=" + telefone +
				", id=" + id +
				", veiculosP=" + veiculosP +
				'}';
	}

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		Cliente cliente = (Cliente) object;
		return nif == cliente.nif && voucher == cliente.voucher && telefone == cliente.telefone && id == cliente.id && java.util.Objects.equals(nome, cliente.nome) && java.util.Objects.equals(morada, cliente.morada) && java.util.Objects.equals(email, cliente.email) && java.util.Objects.equals(veiculosP, cliente.veiculosP);
	}

	public int hashCode() {
		return java.util.Objects.hash(super.hashCode(), nome, nif, morada, voucher, email, telefone, id, veiculosP);
	}

	/**
	 *
	 * @param tipo
	 * @param idVeiculo
	 */
	public void requisitarServico(int tipo, int idVeiculo) {

		Serviço servico = null;
		switch(tipo){
			case(1) -> {
				servico= new ServiçoUniversal();
			}
			case(2) -> {
				servico = new ServiçoEspecifico();
			}
			case(3) -> {
				servico = new CheckUp();
			}
		}
		if (servico !=null) {
			Veículo v = veiculosP.get(idVeiculo);
			if (v != null) v.adicionarServico(servico);
		}
	}


	public Ficha getFicha(int idVeiculo) {
		Veículo v = veiculosP.get(idVeiculo);
		if (v == null)
			return null;
		else return v.getFicha();
	}

}