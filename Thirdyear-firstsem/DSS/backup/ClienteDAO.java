import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClienteDAO {

    private List<Cliente> clientes;

    public ClienteDAO(){
        this.clientes = new ArrayList<>();
    }

    public ClienteDAO(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente get(int idCliente){

        for(Cliente a : this.clientes){
            if(a.getId() == idCliente)
                return a;
        }
        return null;
    }

}