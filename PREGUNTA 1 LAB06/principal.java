package ejercicio1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class principal {
    static Scanner entrada = new Scanner(System.in);
    static double variable1, variable2;
    static int operador;

    public static void main(String[] args) {
        System.out.println("             :::CALCULADORA:::             ");
        do {
            try {
                //Ingresamos el primer numero
                System.out.print("Ingrese x: ");
                variable1 = entrada.nextDouble();

                do {
                    //Mostramos el menu de opciones
                    mostrarMenu();
                    //Ingresamos el operador deseado
                    operador = entrada.nextInt();
                    // Validamos que la opción esté entre 1 y 8
                    while (operador < 1 || operador > 8) {
                        System.out.print("Elija una opción válida: ");
                        operador = entrada.nextInt();
                    }
                    //El switch nos redirige al caso seleccionado
                    switch (operador) {
                        case 1: case 2: case 3: case 4: case 5: case 6:
                            //Ingresamos al metodo realizarOperacion donde se encuentra los distintos casos
                            realizarOperacion();
                            break;
                        case 7:
                            //Esta opcion limpia los valores que anteriormente se ingresaron
                            System.out.println("\nSe limpiaron los valores anteriores...\n");
                            variable1 = 0;
                            variable2 = 0;
                            break;
                        case 8:
                            //Esta opcion termina el programa
                            System.out.println("\nSaliendo...\n");
                            break;
                    }
                } while (operador != 7 && operador != 8);
                //Este bucle se encarga de hacer operaciones con el resultado de una operacion anterior
            } catch (InputMismatchException e) {
                //Si se ingresa un dato de tipo incorrecto a una variable se mostrara el siguiente mensaje
                System.out.println("Error: Ingreso un tipo de variable incorrecta. \nLimpiando la calculadora...\n");
                entrada.nextLine();  // Limpiar el buffer
            } catch (ArithmeticException e) {
                //Si se divide entre 0 o se quiere tener la raiz de un numero negativo se mostrara el siguiente mensaje
                System.out.println(e.getMessage() + "\nLimpiando la calculadora...\n");
            }
        } while (operador != 8);
        //Este bucle se encarga de ingresar las variables y hacer operaciones, hasta que se elija la opcion 8
    }

    // Método para mostrar el menú de operaciones
    public static void mostrarMenu() {
        System.out.println("\n            :::ELIJA UNA OPCION:::         ");
        System.out.println("...........................................");
        System.out.println("|     OPERACION              |   OPCION   |");
        System.out.println("...........................................");
        System.out.println("|     SUMA (+)               |      1     |");
        System.out.println("|     RESTA (-)              |      2     |");
        System.out.println("|     PRODUCTO (*)           |      3     |");
        System.out.println("|     DIVISION (/)           |      4     |");
        System.out.println("|     RAICES                 |      5     |");
        System.out.println("|     POTENCIA (^)           |      6     |");
        System.out.println("|     LIMPIAR                |      7     |");
        System.out.println("|     SALIR                  |      8     |");
        System.out.println("...........................................");
        System.out.print("OPCION: ");
    }

    // Método para manejar la ejecución de operaciones
    public static void realizarOperacion() {
        //Ingresamos la variable2
        System.out.print("Ingrese y: ");
        variable2 = entrada.nextDouble();

        switch (operador) {
            case 1:
                realizarSuma();
                break;
            case 2:
                realizarResta();
                break;
            case 3:
                realizarProducto();
                break;
            case 4:
                realizarDivision();
                break;
            case 5:
                realizarRaices();
                break;
            case 6:
                realizarPotencia();
                break;
        }
    }

    public static void realizarSuma() {
        Suma sum = new Suma(variable1, variable2);
        //Mostramos los resultados
        sum.mostrarResultado();
        //Guardamos los resultados en la variable 1 para luego 
        variable1 = sum.Resultado();
        //Mostramos el mensaje que indica que se guardo el resultado
        mostrarMensajeGuardado();
    }

    public static void realizarResta() {
        Resta rest = new Resta(variable1, variable2);
        //Mostramos los resultados
        rest.mostrarResultado();
        //Guardamos los resultados en la variable 1 para luego 
        variable1 = rest.Resultado();
        //Mostramos el mensaje que indica que se guardo el resultado
        mostrarMensajeGuardado();
    }

    public static void realizarProducto() {
        Producto prod = new Producto(variable1, variable2);
        //Mostramos los resultados
        prod.mostrarResultado();
        //Guardamos los resultados en la variable 1 para luego 
        variable1 = prod.Resultado();
        //Mostramos el mensaje que indica que se guardo el resultado
        mostrarMensajeGuardado();
    }

    public static void realizarDivision() {
        if (variable2 == 0) {
            //Si la variable2 es cero se envia un error
            throw new ArithmeticException("Error: No se puede dividir entre cero.");
        }
        Division div = new Division(variable1, variable2);
        //Mostramos los resultados
        div.mostrarResultado();
        //Guardamos los resultados en la variable 1 para luego 
        variable1 = div.Resultado();
        //Mostramos el mensaje que indica que se guardo el resultado
        mostrarMensajeGuardado();
    }

    public static void realizarRaices() {
        if (variable1 < 0 && variable2 % 2 == 0) {
            //Si la variable1 es negativo y la variable2 es par entonces se lanza el siguiente error
            throw new ArithmeticException("Error: No es posible calcular la raíz del número negativo.");
        }
        Raices rc = new Raices(variable1, variable2);
        //Mostramos los resultados
        rc.mostrarResultado();
        //Guardamos los resultados en la variable 1 para luego 
        variable1 = rc.Resultado();
        //Mostramos el mensaje que indica que se guardo el resultado
        mostrarMensajeGuardado();
    }

    public static void realizarPotencia() {
        if (variable2 != Math.floor(variable2)) {
            //Nos aseguramos que solo se puedan ingresar potencias enteras
            System.out.println("Solo se puede ingresar número enteros.");
            return;
        }
        Potencia pot = new Potencia(variable1, variable2);
        //Mostramos los resultados
        pot.mostrarResultado();
        //Guardamos los resultados en la variable 1 para luego 
        variable1 = pot.Resultado();
        //Mostramos el mensaje que indica que se guardo el resultado
        mostrarMensajeGuardado();
    }

    // Mostrar mensaje después de realizar una operación
    public static void mostrarMensajeGuardado() {
        System.out.println("\n...........................................");
        System.out.println("| Resultado guardado en la variable 'x'   |");
        System.out.println("| Proceda con la siguiente operación...   |");
        System.out.println("...........................................");
    }
}
