import java.util.ArrayList;
import java.util.List;

public class PostoDeTrabalho {

	private int idPosto;
	private List <Vaga> vagas;
	private List<Serviço> serviçosRealizados;
	private List<Serviço> serviçosPorRealizar;

	private final IGestServicos gestServicos = new GestServicos();




	public PostoDeTrabalho(int idPosto, List<Vaga> vagas) {
		this.idPosto = idPosto;
		this.vagas = vagas;
		this.serviçosRealizados = new ArrayList<>();
		this.serviçosPorRealizar = new ArrayList<>();
	}

	public int getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(int idPosto) {
		this.idPosto = idPosto;
	}

	public List<Serviço> getServiçosRealizados() {
		return serviçosRealizados;
	}

	public void setServiçosRealizados(List<Serviço> serviçosRealizados) {
		this.serviçosRealizados = serviçosRealizados;
	}

	public List<Serviço> getServiçosPorRealizar() {
		return serviçosPorRealizar;
	}

	public void setServiçosPorRealizar(List<Serviço> serviçosPorRealizar) {
		this.serviçosPorRealizar = serviçosPorRealizar;
	}

	public int getNewIDServico(){
		return serviçosRealizados.size()+1;
	}



	public void addServicoRealizado(Serviço s){
		serviçosPorRealizar.remove(s);
		serviçosRealizados.add(s);
	}

	public void addServicoPorRealizar(Serviço s){
		serviçosPorRealizar.add(s);
	}

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		PostoDeTrabalho that = (PostoDeTrabalho) object;
		return idPosto == that.idPosto && java.util.Objects.equals(serviçosRealizados, that.serviçosRealizados) && java.util.Objects.equals(serviçosPorRealizar, that.serviçosPorRealizar);
	}

	public int hashCode() {
		return java.util.Objects.hash(super.hashCode(), idPosto, serviçosRealizados, serviçosPorRealizar);
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "PostoDeTrabalho{" +
				"idPosto=" + idPosto +
				", serviçosRealizados=" + serviçosRealizados +
				", serviçosPorRealizar=" + serviçosPorRealizar +
				'}';
	}

	public List<Serviço>  consultarServicos(){
		return this.gestServicos.consultarServicos();
	}


	public void realizarServico(Ficha ficha, int tipoServiço) {
		
	}

}