package ejercicio1;

public class Potencia extends Operadores {
    public Potencia(double x, double y){
        super(x,y);
    }
    @Override
    public double Resultado(){
        return (Math.pow(x, y));
    }
    public void mostrarResultado(){
    
        System.out.printf("%15s%s%n","",":::RESULTADO:::");
        System.out.println("...........................................");
        System.out.printf("|  %10.2f ^ %-10.0f = %-10.2f   |%n", x, y, Math.pow(x,y));
        System.out.println("...........................................");
    }
}