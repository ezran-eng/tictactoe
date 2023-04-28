package org.example;

import java.util.Scanner;

/*

PRE-REQUISITOS QUE DEBEN APLICARSE EN EL DESARROLLO DEL CODIGO
1-Boolean and logical operations
2-Relational operators
3-Conditional statement
4-Ternary operator
5-The while and do-while loops
6-The for-loop
7-Branching statements
8-Iterating over arrays
9-Multidimensional array

Descripción
En esta etapa, vamos a analizar el estado del juego para determinar si alguno de los jugadores ya ha ganado el juego o si todavía está en curso, si el juego es un empate, o si el usuario ha ingresado un estado de juego imposible (dos ganadores o con un jugador que ha hecho demasiados movimientos).

Objetivos
En esta etapa, tu programa debe:
1-Tomar una cadena ingresada por el usuario e imprimir la cuadrícula del juego como en la etapa anterior.
2-Analizar el estado del juego e imprimir el resultado. Estados posibles:

*El juego no ha terminado cuando ninguno de los dos lados tiene tres en línea, pero la cuadrícula todavía tiene celdas vacías.
*Empate cuando ninguno de los lados tiene tres en línea y la cuadrícula no tiene celdas vacías.
*X gana cuando la cuadrícula tiene tres X en línea (incluyendo diagonales).
*O gana cuando la cuadrícula tiene tres O en línea (incluyendo diagonales).
*Imposible cuando la cuadrícula tiene tres X en línea y tres O en línea, o hay muchas más X que O o viceversa (la diferencia debe ser 1 o 0; si la diferencia es 2 o más, entonces el estado del juego es imposible).

En esta etapa, asumiremos que tanto X como O pueden comenzar el juego.
Puedes elegir si usar un espacio o un guion bajo _ para imprimir las celdas vacías.

EJEMPLOS
El símbolo mayor que seguido de un espacio (> ) representa la entrada del usuario. Ten en cuenta que no forma parte de la entrada.
ejemplo 1
> XXXOO__O_
---------
| X X X |
| O O _ |
| _ O _ |
---------
X wins

ejemplo 2
> XOXOXOXXO
---------
| X O X |
| O X O |
| X X O |
---------
X wins

ejemplo 3
> XOOOXOXXO
---------
| X O O |
| O X O |
| X X O |
---------
O wins

ejemplo 4
> XOXOOXXXO
---------
| X O X |
| O O X |
| X X O |
---------
Draw

ejemplo 5
> XO_OOX_X_
---------
| X O   |
| O O X |
|   X   |
---------
Game not finished

ejemplo 6
> XO_XO_XOX
---------
| X O _ |
| X O _ |
| X O X |
---------
Impossible

ejemplo 7
> _O_X__X_X
---------
|   O   |
| X     |
| X   X |
---------
Impossible

ejemplo 8
> _OOOO_X_X
---------
|   O O |
| O O   |
| X   X |
---------
Impossible

PISTAS
1. Primero contar X y O.
Si 'X' + 'X' + 'X' => 264, X gana.
Si 'O' + 'O' + 'O' => 237, O gana.
Si x + o = 9, entonces no hay celdas vacías.
Si ambos ganan o (xs-os>1 o os-xs>1), entonces es imposible.
De lo contrario, cualquiera gana (x u o)
Si hay una celda vacía, entonces el juego no ha terminado.
De lo contrario, es un empate."
*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] grid = new char[3][3];
        int numX = 0, numO = 0;

        // Pide al usuario que ingrese la cadena representando el estado actual del juego
        System.out.print("Ingresa el estado actual del juego: ");
        String input = scanner.nextLine().toUpperCase();

        // Llena la cuadrícula del juego con la cadena de entrada
        int index = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = input.charAt(index);
                if (grid[row][col] == 'X') {
                    numX++;
                } else if (grid[row][col] == 'O') {
                    numO++;
                }
                index++;
            }
        }

        // Imprime la cuadrícula del juego
        System.out.println("---------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        // Analiza el estado del juego y muestra el resultado
        boolean xWins = false, oWins = false;
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == 'X' && grid[i][1] == 'X' && grid[i][2] == 'X') {
                xWins = true;
            } else if (grid[i][0] == 'O' && grid[i][1] == 'O' && grid[i][2] == 'O') {
                oWins = true;
            }
            if (grid[0][i] == 'X' && grid[1][i] == 'X' && grid[2][i] == 'X') {
                xWins = true;
            } else if (grid[0][i] == 'O' && grid[1][i] == 'O' && grid[2][i] == 'O') {
                oWins = true;
            }
        }
        if (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') {
            xWins = true;
        } else if (grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') {
            oWins = true;
        }
        if (grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X') {
            xWins = true;
        } else if (grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O') {
            oWins = true;
        }

        if (xWins && oWins || Math.abs(numX - numO) > 1) {
            System.out.println("Estado del juego ilegal");
        } else if (xWins) {
            System.out.println("X gana");
        } else if (oWins) {
            System.out.println("O gana");
        } else if (numX + numO == 9) {
            System.out.println("Empate");
        } else {
            System.out.println("Juego no terminado");
        }
        scanner.close();
    }
}