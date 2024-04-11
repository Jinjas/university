public class Encomenda {
    private String clientName;
    private String fiscal;
    private String morada;
    private int idEncomenda;
    private String data;

    private int nLinhas;
    private LinhaDeEncomenda[] linhasEncomendas;

    public Encomenda(){
        this.clientName = "";
        this.fiscal = "";
        this.morada = "";
        this.idEncomenda = -1;
        this.data = "";
        this.nLinhas = 5;
        this.linhasEncomendas=new LinhaDeEncomenda[this.nLinhas];
    }
    public Encomenda (String clientName, String fiscal, String morada, int idEncomenda,String data,int nlinhas,LinhaDeEncomenda[] linhasEncomendas){
        this.clientName =clientName;
        this.fiscal = fiscal;
        this.morada = morada;
        this.idEncomenda = idEncomenda;
        this.data = data;
        this.nLinhas = nlinhas;
        this.linhasEncomendas = new LinhaDeEncomenda[this.nLinhas];
        for (int i = 0; i<nLinhas;i++) {
            this.linhasEncomendas[i] =linhasEncomendas[i].clone();
        }
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

    public void setnLinhas(int nLinhas) {
        this.nLinhas = nLinhas;
    }

    public void setLinhasEncomendas(LinhaDeEncomenda[] linhasEncomendas) {
        this.linhasEncomendas = new LinhaDeEncomenda[this.nLinhas];
        for (int i = 0; i<this.nLinhas;i++) {
            this.linhasEncomendas[i] =linhasEncomendas[i].clone();
        }
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

    public int getnLinhas() {
        return nLinhas;
    }

    public LinhaDeEncomenda[] getLinhasEncomendas() {
        return linhasEncomendas;
    }

    public double calculaValorTotal(){
        double total=0;
        for (int i = 0; i<this.nLinhas;i++) {
            total += this.linhasEncomendas[i].calculaValorLinhaEnc();}
        return total;
    }
    public double calculaValorDesconto(){
        double total=0;
        for (int i = 0; i<this.nLinhas;i++) {
            total += this.linhasEncomendas[i].calculaValorTaxes();}
        return total;
    }
    public int numeroTotalProdutos(){
        int total=0;
        for (int i = 0; i<this.nLinhas;i++) {
            total += this.linhasEncomendas[i].getnEncomendados();}
        return total;
    }
}
