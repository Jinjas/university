import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CasaInteligente {
    private List<Lampada> lampadasList;

    public CasaInteligente(){
        this.lampadasList=new ArrayList<Lampada>();

    }
    public CasaInteligente(List<Lampada> lampadasList) {
        this.lampadasList = new ArrayList<Lampada>();
        Iterator<Lampada> it = lampadasList.iterator();
        while (it.hasNext()) {
            Lampada c = it.next();
            this.addLampada(c.clone());
        }
    }
    public CasaInteligente (CasaInteligente casa){
        this.lampadasList =  casa.getLampadasList();
    }

    public List<Lampada> getLampadasList() {
        return lampadasList;
    }

    public void setLampadasList(List<Lampada> lampadasList) {

        this.lampadasList = new ArrayList<Lampada>();
        Iterator<Lampada> it = lampadasList.iterator();
        while (it.hasNext()) {
            Lampada c = it.next();
            this.addLampada(c.clone());
        }
    }
    public void addLampada(Lampada l){
        this.lampadasList.add(l.clone());
    }

    public void ligaLampadaNormal(int index){
        this.lampadasList.get(index).lampON();
    }

    public void ligaLampadaEco(int index){
        lampadasList.get(index).lampECO();
    }

    public int qtEmEco(){
        return (int) lampadasList.stream().filter(l -> l.getModo() == Lampada.Modo.ECO).count();

    }
    public void removeLampada(int index){
        this.lampadasList.remove(index);
    }
    public void ligaTodasEco(){
        this.lampadasList.stream().forEach(lamp->lamp.lampECO());
    }
    public void ligaTodasMax(){
        this.lampadasList.stream().forEach(lamp->lamp.lampON());
    }

    public double consumoTotal() {
        double total = 0;
        Iterator<Lampada> it = lampadasList.iterator();
        while (it.hasNext()) {
            Lampada c = it.next();
            total += c.getConsumoTotal();
        }
    return total;
    }

    public Lampada maisGastadora(){
        return this.lampadasList.stream().max((lampada1, lampada2)->Double.compare(lampada1.getConsumoTotal(),lampada2.getConsumoTotal())).map(Lampada::clone).orElse(null);
    }

    public Set<Lampada> lampadasEmModoEco(){
        return this.lampadasList.stream().filter(l -> l.getModo() == Lampada.Modo.ECO).map(Lampada::clone).collect(Collectors.toSet());
    }
    public void reset(){
        this.lampadasList.forEach(Lampada::resetPeriodo);
    }
    public Set<Lampada> podiumEconomia(){
        return this.lampadasList.stream().sorted((lampada1, lampada2)->-Double.compare(lampada1.getConsumoTotal(),lampada2.getConsumoTotal())).limit(3).collect(Collectors.toSet());
                //se estiver organizado usa-se o limit
                // para otop que quisesse
    }
}

