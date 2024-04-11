import java.util.List;

public interface IGestPostoTrabalho {

    List<Serviço> consultarServicos(int idPosto);
    void realizarServico(Ficha ficha, int tipoServiço);
}