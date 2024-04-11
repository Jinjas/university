import java.util.*;
import java.util.stream.Collectors;

public class GestaoEncomendas {
    private Map<Integer,Encomenda> encomendas;

    public GestaoEncomendas(){
        this.encomendas = new HashMap<>();
    }
    public GestaoEncomendas(Map encomendas){
        this.encomendas = encomendas;
    }

    public Map<Integer, Encomenda> getEncomendas() {
        return this.encomendas.entrySet().stream().collect(Collectors.toMap(k->k.getKey(),k->k.getValue().clone()));
    }

    public void setEncomendas(Map<Integer, Encomenda> encomendas) {
        this.encomendas = encomendas.entrySet().stream().collect(Collectors.toMap(k->k.getKey(),k->k.getValue().clone()));
    }

    public Set<Integer> todosCodigosEnc(){
        return this.encomendas.values().stream().map(Encomenda::getIdEncomenda).collect(Collectors.toSet());
    }

    public void addEncomenda(Encomenda enc){
        this.encomendas.put(enc.getIdEncomenda(),enc.clone());
    }
    public void removeEncomenda(Integer codEnc){
        this.encomendas.remove(codEnc);
    }

    public Encomenda maiorID(){
        return this.encomendas.values().stream().max((enc1,enc2)-> Integer.compare(enc1.getIdEncomenda(), enc2.getIdEncomenda())).orElse(null).clone();
    }

    public Map<String,String> ola(){
    }
    public Integer encomendaComMaisProdutos(){

    }
}

