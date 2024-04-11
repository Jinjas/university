import java.util.ArrayList;
import java.util.List;

public class GestServicos implements IGestServicos{

    private final List<Serviço> servicos = new ArrayList<>();

    public GestServicos() {
    }

    public List<Serviço>  consultarServicos(){
        return this.servicos;
    }

    public void adicionarServico(Serviço servico){

    }


    public void atualizarServico(int tipo, boolean estado){

    }

}
