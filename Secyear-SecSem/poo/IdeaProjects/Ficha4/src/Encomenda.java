import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Encomenda {
    private String clientName;
    private String fiscal;
    private String morada;
    private int idEncomenda;
    private String data;

    private List<LinhaDeEncomenda> linhasEncomendas;

    public Encomenda(){
        this.clientName = "";
        this.fiscal = "";
        this.morada = "";
        this.idEncomenda = -1;
        this.data = "";
        this.linhasEncomendas=new ArrayList<LinhaDeEncomenda>();
    }
    public Encomenda (String clientName, String fiscal, String morada, int idEncomenda,String data,int nlinhas,Iterator<LinhaDeEncomenda> lista){
        this.clientName =clientName;
        this.fiscal = fiscal;
        this.morada = morada;
        this.idEncomenda = idEncomenda;
        this.data = data;
        this.linhasEncomendas = new ArrayList<LinhaDeEncomenda>();

        lista.forEachRemaining(linhaDeEncomenda -> this.linhasEncomendas.add(linhaDeEncomenda.clone()));

    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }
    public void setMorada(String morada) {
        this.morada = morada;
    }
    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLinhasEncomendas(ArrayList<LinhaDeEncomenda> linhasEncomendas) {
        this.linhasEncomendas = linhasEncomendas;
    }


    public String getClientName() {
        return clientName;
    }

    public String getFiscal() {
        return fiscal;
    }

    public String getMorada() {
        return morada;
    }

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public String getData() {
        return data;
    }

    public List<LinhaDeEncomenda> getLinhasEncomendas() {
        return linhasEncomendas;
    }

    public double calculaValorTotal(){
        double total=0;
        Iterator<LinhaDeEncomenda> it = this.linhasEncomendas.iterator();
        while(it.hasNext()){
            LinhaDeEncomenda c = it.next();
            total += c.calculaValorLinhaEnc();
        }
        return total;
    }
    public double calculaValorDesconto(){
        double total=0;
        Iterator<LinhaDeEncomenda> it = this.linhasEncomendas.iterator();
        while(it.hasNext()){
            LinhaDeEncomenda c = it.next();
            total += c.calculaValorDisconto();
        }
        return total;
    }
    public int numeroTotalProdutos(){
        int total=0;
        Iterator<LinhaDeEncomenda> it = this.linhasEncomendas.iterator();
        while(it.hasNext()){
            LinhaDeEncomenda c = it.next();
            total += c.getnEncomendados();
        }
        return total;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        Iterator<LinhaDeEncomenda> it = this.linhasEncomendas.iterator();
        while(it.hasNext()){
            LinhaDeEncomenda c = it.next();
            if(refProduto == c.getReferencia())
                return true;
        }
        return false;
    }

    public void adicionaLinha(LinhaDeEncomenda linha){
        this.linhasEncomendas.add(linha.clone());
    }
    public void removeProduto(String codProd){
        Iterator<LinhaDeEncomenda> it = this.linhasEncomendas.iterator();
        while(it.hasNext()){
            LinhaDeEncomenda c = it.next();
            if(codProd == c.getReferencia())
                this.linhasEncomendas.remove(c);
        }
    }
}
