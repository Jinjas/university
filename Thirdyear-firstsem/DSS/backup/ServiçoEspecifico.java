import java.util.*;

public class ServiçoEspecifico extends Serviço {

	private Collection<Categoria> categorias;

	public ServiçoEspecifico(long tempoEsperado, String nome, Boolean estado, int tipoServiço, Collection<Categoria> categorias) {
		super(tempoEsperado, nome, estado, tipoServiço);
		this.categorias = categorias;
	}

	public ServiçoEspecifico(){
		super(3000,"Específico",false,2);
	}

}