package ejercicio1;

public class Raices extends Operadores{
    public Raices(double x, double y){
        super(x,y);
    }
    @Override
    public double Resultado(){
        if (x < 0 && (y%2)!=0) {
            return -Math.pow(Math.abs(x), 1 / y); 
        } else {
            return Math.pow(x, 1 / y); 
        }    }
    public void mostrarResultado(){
    
        System.out.printf("%15s%s%n","",":::RESULTADO:::");
        System.out.println("...........................................");
        System.out.printf("|   %7.2f ^ 1/%-8.0f = %-10.2f     |%n", x,y,Resultado());
        System.out.println("...........................................");    }
}