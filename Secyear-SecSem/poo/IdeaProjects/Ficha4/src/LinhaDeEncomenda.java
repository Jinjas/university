import java.util.Objects;

public class LinhaDeEncomenda {
    private String referencia;
    private String descricao;
    private double precoBruto;
    private int nEncomendados;
    private short taxPercentage;
    private short discontPercentage;

    public LinhaDeEncomenda(){
        referencia= "";
        descricao = "";
        precoBruto = 0.0;
        nEncomendados=0;
        taxPercentage = 0;
        discontPercentage = 0;
    }
    public LinhaDeEncomenda (String referencia,String descricao, double precoBruto, int nEncomendados, short taxPercentage, short discontPercentage){
        this.referencia = referencia;
        this.descricao = descricao;
        this.precoBruto = precoBruto;
        this.nEncomendados = nEncomendados;
        this.taxPercentage = taxPercentage;
        this.discontPercentage = discontPercentage;
    }
    public LinhaDeEncomenda(LinhaDeEncomenda linha){
        this.referencia = linha.referencia;
        this.descricao = linha.descricao;
        this.precoBruto = linha.precoBruto;
        this.nEncomendados = linha.nEncomendados;
        this.taxPercentage = linha.taxPercentage;
        this.discontPercentage= linha.discontPercentage;
    }
    public String getReferencia() {
        return referencia;
    }
    public String getDescricao() {
        return descricao;
    }
    public double getPrecoBruto() {
        return precoBruto;
    }
    public int getnEncomendados() {
        return nEncomendados;
    }
    public short getTaxPercentage() {
        return taxPercentage;
    }

    public short getDiscontPercentage() {
        return discontPercentage;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoBruto(double precoBruto) {
        this.precoBruto = precoBruto;
    }

    public void setnEncomendados(int nEncomendados) {
        this.nEncomendados = nEncomendados;
    }

    public void setTaxPercentage(short taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public void setDiscontPercentage(short discontPercentage) {
        this.discontPercentage = discontPercentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinhaDeEncomenda that = (LinhaDeEncomenda) o;
        return Double.compare(that.precoBruto, precoBruto) == 0 && nEncomendados == that.nEncomendados && taxPercentage == that.taxPercentage && discontPercentage == that.discontPercentage && Objects.equals(referencia, that.referencia) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public String toString() {
        return "linhaDeEncomenda{" +
                "referencia='" + this.referencia + '\'' +
                ", descricao='" + this.descricao + '\'' +
                ", precoBruto=" + this.precoBruto +
                ", nEncomendados=" + this.nEncomendados +
                ", taxPercentage=" + this.taxPercentage +
                ", discontPercentage=" + this.discontPercentage +
                '}';
    }

    public LinhaDeEncomenda clone(){
        return new LinhaDeEncomenda(this);
    }

    public double calculaValorLinhaEnc(){
        double aPagar = this.getPrecoBruto() * this.getnEncomendados();
        return aPagar + this.calculaValorDisconto() - this.calculaValorTaxes();
    }

    public double calculaValorDisconto(){
        double aPagar = this.getPrecoBruto() * this.getnEncomendados();
        return aPagar *this.getDiscontPercentage()/100;
    }
    public double calculaValorTaxes(){
        double aPagar = this.getPrecoBruto() * this.getnEncomendados();
        return aPagar *this.getTaxPercentage()/100;
    }

}