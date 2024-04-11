public class Ponto{

    /**variaveis de instancia*/
    private int x;
    private int y;

    /**CONSTRUTORES*/
    /**por omissão*/
    public Ponto() {
    this.x = 0;
    this.y = 0;
    }
    
    /**por parametros*/
    public Ponto(int cx, int cy) {
    this.x = cx;
    this.y = cy;
    }

    /**construtor de cópia*/
    public Ponto(Ponto umPonto) {
    this.x = umPonto.getx();
    this.y = umPonto.gety();
    }
        
    /**GETTERS*/
    public int getx() {
        return this.x;
    }
    public int gety() {
        return this.y;
    }
    
    /**SETTERS*/
    public void setx(int novoX) {
        this.x = novoX;
    }
    public void sety(int novoY) {
        this.y = novoY;
    }
    
    /**desloca somando um delta*/
    public void deslocamento(int deltaX, int deltaY){
        this.x += deltaX;
        this.y += deltaY;
    }   
    /**Verifica se é igual ao objeto dado */
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if ((obj == null) || (this.getClass() != obj.getClass()))
            return false;
        
        Ponto p = (Ponto) obj;
        return (this.x == p.getx() && this.y == p.gety());
    }
    /**retorna a string do objeto */
    public String toString() {
        return "Ponto Cx = " + this.x+ ", Cy = " + this.y;
    }
    /**cria um clone */
    public Ponto clone() {
        return new Ponto (this);
    }
}









