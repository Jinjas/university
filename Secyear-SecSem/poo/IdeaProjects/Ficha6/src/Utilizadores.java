import java.time.LocalDate;

public class Utilizadores {
    private String email;
    private String password;
    private String nome;
    private String genero;
    private int altura;
    private int peso;
    private LocalDate dataNasc;
    private LocalDate dataReg;

    public Utilizadores() {
        Utilizadores utilizadores = new Utilizadores();
        this.email = "";
        this.password = "";
        this.nome = "";
        this.genero = "";
        this.altura = 0;
        this.peso = 0;
        this.dataNasc = LocalDate.now();
        this.dataReg = LocalDate.now();
    }

    public Utilizadores(String email, String password, String nome, String genero, int altura, int peso, LocalDate dataNasc, LocalDate dataReg) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.dataNasc = dataNasc;
        this.dataReg = dataReg;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNome() {
        return this.nome;
    }

    public String getGenero() {
        return this.genero;
    }

    public int getAltura() {
        return this.altura;
    }

    public int getPeso() {
        return this.peso;
    }

    public LocalDate getDataNasc() {
        return this.dataNasc;
    }

    public LocalDate getDataReg() {
        return this.dataReg;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setDataReg(LocalDate dataReg) {
        this.dataReg = dataReg;
    }
}

