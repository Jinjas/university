import java.util.List;

public interface IGestServicos {

    void adicionarServico(Serviço servico);

    List<Serviço> consultarServicos();

    void atualizarServico(int tipo, boolean estado);

}