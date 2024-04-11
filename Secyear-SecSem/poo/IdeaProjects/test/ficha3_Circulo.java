public class Circulo{

    /**variaveis de instancia*/
    private double x;
    private double y;
    private double raio;

    /**CONSTRUTORES*/
    /**por omissão*/
    public Circulo() {
    this.x = 0;
    this.y = 0;
    this.raio = 5;
    }
    
    /**por parametros*/
    public Circulo(double cx, double cy,double craio) {
    this.x = cx;
    this.y = cy;
    this.raio = craio;
    }

    /**construtor de cópia*/
    public Circulo(double umCirculo) {
    this.x = umCirculo.getX();
    this.y = umCirculo.getY();
    this.raio = umCirculo.getRaio();
    }
        
    /**GETTERS*/
    public double getX() {
        return this.x;
    }
    public double getyY() {
        return this.y;
    }
    public double getRaio() {
        rerutn this.raio;
    }
    
    /**SETTERS*/
    /**atualiza X */
    public void setX(double novoX) {
        this.x = novoX;
    }
    /**atualiza Y */
    public void setY(double novoY) {
        this.y = novoY;
    }
    /**atualiza raio */
    public void setRaio(double novoRaio) {
        this.raio = novoRaio;
    }

    /**altera o centro para as coordenadas X e Y dadas*/
    public void alteraCentro(double novoX, double novoY){
        this.x = novoX;
        this.y = novoY;
    }
    /**calcular a area do circulo*/
    public double calculaArea() {
        return 3.14 * this.raio * this.raio;
    }
    /**calcular o perimetro do circulo */
    public double calculaPerimetro() {
        return 3.14 * this.raio * 2;
    }


    /**Verifica se é igual ao objeto dado */
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if ((obj == null) || (this.getClass() != obj.getClass()))
            return false;
        
        Circulo p = (Circulo) obj;
        return (this.x == p.getX() && this.y == p.getY() && this.raio == p.getRaio());
    }

    /**cria um clone */
    public Circulo clone() {
        return new Circulo (this);
    }
    /**transforma um Circulo numa string */
    public String toString() {
        return "Centro nas coordenadas (x,y) com x = " + this.x + "e y = " + this.y + "e com raio = " + this.raio;
    }
}