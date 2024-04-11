import java.util.HashMap;
import java.util.Map;

public class GestUtilizadores implements IGestUtilizadores{
    //email - Cliente
    private Map<Integer, Cliente> clientes;
    private Map<Integer, Funcionario> funcionarios;

    public GestUtilizadores() {
        this.clientes = new HashMap<>();
        this.funcionarios = new HashMap<>();
    }

    public Cliente getCliente(int id){ return this.clientes.get(id);}

    public Map<Integer, Cliente> getclientes() {
        return clientes;
    }

    public void setclientes(Map<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    public Map<Integer, Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Map<Integer, Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getEmailPorID(int id){
        return clientes.get(id).getEmail();
    }

    public boolean existeEmail(String email){
        boolean existe = false;
        for(Integer id: clientes.keySet()){
            Cliente c = clientes.get(id);
            if(c.getEmail().equals(email)){
                existe = true;
                break;
            }
        }
        return existe;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Gestorclientes{" +
                "clientes=" + clientes +
                ", funcionarios=" + funcionarios +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        GestUtilizadores that = (GestUtilizadores) object;
        return java.util.Objects.equals(clientes, that.clientes) && java.util.Objects.equals(funcionarios, that.funcionarios);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), clientes, funcionarios);
    }


    @Override
    public void requisitarServico(int idCliente, int tipo, int idVeiculo) {
        Cliente c = clientes.get(idCliente);
        if (c != null){ c.requisitarServico(tipo,idVeiculo);}
    }

    public Ficha getFicha(int idCliente, int idVeiculo){
        Cliente c = clientes.get(idCliente);
        if (c == null){
            return null;
        }
        else return c.getFicha(idVeiculo);
    }

    public void initTrabalho(int id){
        Funcionario f = funcionarios.get(id);

        if (f != null) f.initTrabalho();
    }
    public void terminarTrabalho(int id){
        Funcionario f = funcionarios.get(id);

        if (f != null) f.terminarTrabalho();
    }


}
