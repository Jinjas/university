import java.util.ArrayList;
import java.util.List;

public class ServiçoDAO {

    private List<Serviço> servicos;

    public ServiçoDAO(){
        this.servicos = new ArrayList<>();
    }

    public ServiçoDAO(List<Serviço> servicos) {
        this.servicos = servicos;
    }

    public void add(Serviço servico){
        this.servicos.add(servico);
    }

    /*
    public Serviço get(int idCliente){

        for(Serviço  a : this.servicos){
            if(a.getFichaId() == idCliente)
                return a;
        }
        return null;
    }
    */
}