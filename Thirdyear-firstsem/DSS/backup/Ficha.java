import java.util.ArrayList;
import java.util.List;

public class Ficha {
	private boolean checkupRequisitado;
	private List<Serviço> servico;

	public Ficha() {
		this.checkupRequisitado = false;
		this.servico = new ArrayList<>();
	}


	public void addServico(Serviço s){
		this.servico.add(s);
	}


	public void atualizarServico(int tipo, boolean estado){

	}

}