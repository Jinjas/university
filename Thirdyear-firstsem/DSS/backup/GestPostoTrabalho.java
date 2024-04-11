import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestPostoTrabalho implements IGestPostoTrabalho {
    private Map<Integer, PostoDeTrabalho> postos;

    public GestPostoTrabalho() {
        this.postos = new HashMap<>();
    }

    public void realizarServico(Ficha ficha, int tipoServiço) {

    }

    public List<Serviço> consultarServicos(int idPosto) {
        PostoDeTrabalho pt = postos.get(idPosto);
        if (pt != null) {
            //to implement
            return pt.consultarServicos();
        }
        return null;
    }
}