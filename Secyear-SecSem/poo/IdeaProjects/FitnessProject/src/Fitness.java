import jdk.jshell.execution.Util;

import javax.print.attribute.standard.RequestingUserName;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Fitness implements Serializable {

    private String name;
    private Map<String, Utilizador> users;


    public Fitness(){
        name = "";
        users = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Fitness loadState (String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        Fitness f = (Fitness) ois.readObject();
        ois.close();
        return f;
    }

    public void saveState (String filename) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    public boolean hasUsers(){return !users.isEmpty();}

    public void addUser(String email){
        Utilizador user = new Utilizador();
        user.setEmail(email);
        users.put(email,user);
    }
    public Utilizador getUtilizador(String code) {
        Utilizador u = users.get(code);
        return u.clone();
    }

    public boolean existsUser(String email){
        return users.containsKey(email);
    }

    public int nrOfUsers(){
        return users.size();
    }

    public int nrOfUsers(String atividade,String utilizador){
        return (int) getUtilizador(utilizador).getAtividades().values().stream().filter(l->l.getCodigo()==atividade).count();
    }

    //public List<Atividade> getAllAtividades(){

    //}


    public void adiciona(String email, Set<Atividade> activs){
        activs.forEach(l-> users.get(email).addAtividade(l));
    }
    public int tempoTotalUtilizador(String email){
        return getUtilizador(email).getAtividades().values().stream().mapToInt(Atividade::getDuracao).sum();
    }

    public void addActivity(String utilizador,Atividade act){
        users.get(utilizador).addAtividade(act);
    }

    //usar get all atividades public Actividade actividadeMaisExigente(){}


    //public Utilizador utilizadorMaisActivo(){    }


    @Override
    public String toString() {
        return "Fitness{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}

