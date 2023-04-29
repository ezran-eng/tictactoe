package org.example;

import java.util.Scanner;

/*

Descripción
¡Nuestro juego está casi listo! Ahora combinemos lo que hemos aprendido en las etapas anteriores para hacer un juego de tic-tac-toe que dos jugadores puedan jugar desde el principio (con una cuadrícula vacía) hasta el final (hasta que haya un empate o uno de los jugadores gane).

El primer jugador tiene que jugar como X y su oponente juega como O.

Objetivos
En esta etapa, deberás escribir un programa que:

1-Imprima una cuadrícula vacía al comienzo del juego.
2-Cree un bucle de juego donde el programa solicite al usuario ingresar las coordenadas de la celda, analice el movimiento para verificar su corrección y muestre una cuadrícula con los cambios si todo está bien.
3-Finalice el juego cuando alguien gane o haya un empate.
Deberás imprimir el resultado final al final del juego. ¡Buena suerte!

EJEMPLOS
El símbolo mayor que seguido de un espacio (> ) representa la entrada del usuario. Ten en cuenta que no forma parte de la entrada.
 ---------
|       |
|       |
|       |
---------
> 2 2
---------
|       |
|   X   |
|       |
---------
> 2 2
This cell is occupied! Choose another one!
> two two
You should enter numbers!
> 1 4
Coordinates should be from 1 to 3!
> 1 1
---------
| O     |
|   X   |
|       |
---------
> 3 3
---------
| O     |
|   X   |
|     X |
---------
> 2 1
---------
| O     |
| O X   |
|     X |
---------
> 3 1
---------
| O     |
| O X   |
| X   X |
---------
> 2 3
---------
| O     |
| O X O |
| X   X |
---------
> 3 2
---------
| O     |
| O X O |
| X X X |
---------
X wins
*/
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String x = s.next();
        char[][] field = new char[3][3];
        int num_x = 0, num_o = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                field[i][j] = x.charAt(i * 3 + j);
                if (field[i][j] == 'X') num_x++;
                if (field[i][j] == 'O') num_o++;
            }
        }
        printField(field);
        while (true) {
            System.out.println("Enter the coordinates: ");
            int x1, x2;
            try {
                x1 = s.nextInt();
                x2 = s.nextInt();
                if (x1 < 1 || x1 > 3 || x2 < 1 || x2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (field[x1 - 1][x2 - 1] != '_') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        field[x1 - 1][x2 - 1] = 'X';
                        break;
                    }
                }
            } catch(Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
        printField(field);
    }
    public static void printField(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; ++i) {
            System.out.print("| ");
            for (int j = 0; j < 3; ++j) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}