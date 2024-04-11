import java.util.ArrayList;
import java.util.List;

public class VeículoDAO {

    private List<Veículo> veiculos;

    public VeículoDAO(){
        this.veiculos = new ArrayList<>();
    }

    public VeículoDAO(List<Veículo> veiculos) {
        this.veiculos = veiculos;
    }

    public Veículo get(int idCliente){

        for(Veículo  a : this.veiculos){
           // if(a.getFichaId() == idCliente)
                return a;
        }
        return null;
    }

}