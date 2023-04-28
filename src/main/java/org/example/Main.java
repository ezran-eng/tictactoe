package org.example;

/*
Descripción
Nuestro programa debe ser capaz de mostrar la cuadrícula en todas las etapas del juego. Ahora vamos a escribir un programa que permita al usuario ingresar una cadena que represente el estado del juego e imprima correctamente la cuadrícula del juego 3x3 en función de esta entrada. También agregaremos algunos límites alrededor de la cuadrícula del juego.

Objetivos
En esta etapa, escribirás un programa que:
Lee una cadena de 9 símbolos desde la entrada y los muestra al usuario en una cuadrícula de 3x3. La cuadrícula solo puede contener símbolos X, O y _.
Imprime una línea de guiones --------- encima y debajo de la cuadrícula, agrega un símbolo de barra vertical | al principio y al final de cada línea de la cuadrícula, y agrega un espacio entre todos los caracteres en la cuadrícula.
EJEMPLOS
El símbolo de mayor que seguido por un espacio (> ) representa la entrada del usuario. Ten en cuenta que no forma parte de la entrada.
ejemplo 1
> O_OXXO_XX
---------
| O _ O |
| X X O |
| _ X X |
---------
ejemplo 2
> OXO__X_OX
---------
| O X O |
| _ _ X |
| _ O X |
---------
PISTAS
la solución simple es obtener los elementos de una cadena utilizando el método charAt(), también debes dar formato a tu salida. Por ejemplo, System.out.println("| "+ enter.charAt(0) + " "+ enter.charAt(1) + " "+enter.charAt(2) +" |"); ))

PRE-REQUISITOS PARA FORMULAR EL CODIGO
*Increment and decrement
*Calling a method
*Primitive and reference types
*Array
*Characters
*String
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String enter = scanner.nextLine();
        System.out.println("---------");
        System.out.println("| " + enter.charAt(0) + " " + enter.charAt(1) + " " + enter.charAt(2) + " |");
        System.out.println("| " + enter.charAt(3) + " " + enter.charAt(4) + " " + enter.charAt(5) + " |");
        System.out.println("| " + enter.charAt(6) + " " + enter.charAt(7) + " " + enter.charAt(8) + " |");
        System.out.println("---------");
    }
}