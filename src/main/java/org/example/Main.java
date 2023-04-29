package org.example;

import java.util.Scanner;

/*

PRE-REQUISITOS QUE DEBEN APLICARSE EN EL DESARROLLO DEL CODIGO
1-Write, compile, and run
2-Errors in programs

Descripción
Es hora de hacer nuestro juego interactivo. Ahora vamos a agregar la capacidad para que un usuario haga un movimiento. Para hacer esto, necesitamos dividir la cuadrícula en celdas. Supongamos que la celda superior izquierda tiene las coordenadas (1, 1) y la celda inferior derecha tiene las coordenadas (3, 3):

(1, 1) (1, 2) (1, 3)
(2, 1) (2, 2) (2, 3)
(3, 1) (3, 2) (3, 3)

El programa debe pedir al usuario que ingrese las coordenadas de la celda donde quieren hacer un movimiento.

En esta etapa, el usuario juega como X, no O. Tenga en cuenta que la primera coordenada va de arriba hacia abajo y la segunda coordenada va de izquierda a derecha. Las coordenadas pueden incluir los números 1, 2 o 3.

¿Qué sucede si el usuario ingresa coordenadas incorrectas? El usuario podría ingresar símbolos en lugar de números, o ingresar coordenadas que representen celdas ocupadas o celdas que ni siquiera estén en la cuadrícula. Debes verificar la entrada del usuario y capturar posibles excepciones.

Objetivos
El programa debería funcionar de la siguiente manera:

1-Obtener la cuadrícula inicial de 3x3 desde la entrada como en las etapas anteriores. Aquí, el usuario debería ingresar 9 símbolos que representen el campo, por ejemplo, XXOO_OX.
2-Mostrar esta cuadrícula de 3x3 como en las etapas anteriores.
3-Pedir al usuario que realice un movimiento. El usuario debería ingresar 2 números de coordenadas que representen la celda donde quieren colocar su X, por ejemplo, 1 1.
4-Analizar la entrada del usuario. Si la entrada es incorrecta, informar al usuario por qué su entrada es incorrecta:
Imprimir "¡Esta celda está ocupada! ¡Elige otra!" si la celda no está vacía.
Imprimir "¡Debes ingresar números!" si el usuario ingresa símbolos no numéricos en la entrada de coordenadas.
Imprimir "¡Las coordenadas deben estar entre 1 y 3!" si el usuario ingresa coordenadas fuera de la cuadrícula del juego.
Seguir pidiendo al usuario que ingrese las coordenadas hasta que la entrada del usuario sea válida.
5-Si la entrada es correcta, actualizar la cuadrícula para incluir el movimiento del usuario e imprimir la cuadrícula actualizada en la consola.
Para resumir, necesitas mostrar el campo 2 veces: una vez antes del movimiento del usuario (basado en la primera línea de entrada) y una vez después de que el usuario haya ingresado coordenadas válidas (entonces necesitas actualizar la cuadrícula para incluir ese movimiento).

EJEMPLOS
El símbolo mayor que seguido de un espacio (> ) representa la entrada del usuario. Ten en cuenta que no forma parte de la entrada.

ejemplo 1
> X_X_O____
---------
| X   X |
|   O   |
|       |
---------
> 3 1
---------
| X   X |
|   O   |
| X     |
---------

ejemplo 2
> _XXOO_OX_
---------
|   X X |
| O O   |
| O X   |
---------
> 1 1
---------
| X X X |
| O O   |
| O X   |
---------

ejemplo 4
> _XXOO_OX_
---------
|   X X |
| O O   |
| O X   |
---------
> 2 3
---------
|   X X |
| O O X |
| O X   |
---------

ejemplo 5
> _XXOO_OX_
---------
|   X X |
| O O   |
| O X   |
---------
> 3 1
This cell is occupied! Choose another one!
> 1 1
---------
| X X X |
| O O   |
| O X   |
---------

ejemplo 6
> _XXOO_OX_
---------
|   X X |
| O O   |
| O X   |
---------
> one
You should enter numbers!
> one one
You should enter numbers!
> 1 1
---------
| X X X |
| O O   |
| O X   |
---------

ejemplo 7
> _XXOO_OX_
---------
|   X X |
| O O   |
| O X   |
---------
> 4 1
Coordinates should be from 1 to 3!
> 1 4
Coordinates should be from 1 to 3!
> 1 1
---------
| X X X |
| O O   |
| O X   |
---------

PISTAS QUE TE PUEDEN AYUDAR A PROGRAMAR MEJOR
Si tiene problemas para mapear en el sistema de coordenadas:
tablero[3 - y][x - 1] donde x es el primer número ingresado, y es el segundo número ingresado, y tablero es su tablero de tres en raya de tipo char[][].
"String input = scanner.next();
if ( (input.matches("\d")) ) // comprueba que la cadena de entrada consiste en dígitos".

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