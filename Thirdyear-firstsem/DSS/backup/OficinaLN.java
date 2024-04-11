import java.util.ArrayList;
import java.util.List;

public class OficinaLN implements IOficinaLN {
	private final IGestUtilizadores gestorClientes = new GestUtilizadores();
	private final IGestPostoTrabalho gestorPostosTrabalho = new GestPostoTrabalho();

	private final List<Turno> turnos = new ArrayList<>();

	public OficinaLN() {
	}


	public void realizarServico(int idCliente, int idVeiculo, int tipoServiço, int idPosto) {
		//Ficha ficha = gestorClientes.getclientes().get(idCliente).getFicha();
		//Serviço s = ficha.getServiço(tipoServiço);
		//PostoDeTrabalho posto = gestorPostosTrabalho.getPostos().get(idPosto);
		//posto.addServicoRealizado(s);
	}

	public void requisitarServico(int idCliente, int tipo, int idVeiculo) {

		gestorClientes.requisitarServico(idCliente,tipo,idVeiculo);

		throw new UnsupportedOperationException();
	}


	public List<Serviço> consultarServicos(int idPosto) {
		return gestorPostosTrabalho.consultarServicos(idPosto);
	}

}