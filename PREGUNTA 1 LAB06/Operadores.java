package ejercicio1;

public abstract class Operadores {
    protected double x, y;
    //constructores
    public Operadores(){
    }
    public Operadores(double x, double y){
        this.x=x;
        this.y=y;
    }
    //GETTERS
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    //SETTERS
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    //metodos abstractos
    abstract double Resultado();
    abstract void mostrarResultado();
}
