package ejercicio1;

public class Division extends Operadores{
    public Division(double x, double y){
        super(x,y);
    }
    @Override
    public double Resultado(){
        return (x/y);
    }
    public void mostrarResultado(){

        System.out.printf("%15s%s%n","",":::RESULTADO:::");
        System.out.println("...........................................");
        System.out.printf("|  %10.2f / %-10.2f = %-10.2f   |%n", x, y, (x / y));
        System.out.println("...........................................");
    }
}