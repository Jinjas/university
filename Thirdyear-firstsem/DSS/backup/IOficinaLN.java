import java.util.List;

public interface IOficinaLN {

    void realizarServico(int idCliente, int idVeiculo, int tipoServiço, int idPosto);
    void requisitarServico(int idCliente, int tipo, int idVeiculo);
    List<Serviço> consultarServicos(int idPosto);


}