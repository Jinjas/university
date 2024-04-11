public interface IGestUtilizadores {

    void requisitarServico(int idCliente,int tipo, int idVeiculo);
    Ficha getFicha(int idCliente, int idVeiculo);

    void initTrabalho(int id);

    void terminarTrabalho(int id);

}