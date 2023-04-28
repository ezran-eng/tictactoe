package org.example;

import java.util.Scanner;

/*

PRE-REQUISITOS QUE DEBEN APLICARSE EN EL DESARROLLO DEL CODIGO
1-Write, compile, and run
2-Errors in programs

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


*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "_________"; // Cuadrícula del juego
        char[] cells = input.toCharArray();

        printGrid(cells); // Imprimir cuadrícula del juego

        while (true) {
            boolean xWins = checkWin(cells, 'X');
            boolean oWins = checkWin(cells, 'O');
            boolean emptyCells = checkEmptyCells(cells);

            if (xWins && oWins || Math.abs(countCells(cells, 'X') - countCells(cells, 'O')) > 1) {
                System.out.println("Impossible");
                break;
            } else if (xWins) {
                System.out.println("X wins");
                break;
            } else if (oWins) {
                System.out.println("O wins");
                break;
            } else if (!emptyCells) {
                System.out.println("Draw");
                break;
            }

            System.out.print("Enter the coordinates: ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                int index = 3 * row + col;
                if (cells[index] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    cells[index] = getPlayer(cells);
                    printGrid(cells);
                }
            }
        }
    }

    public static void printGrid(char[] cells) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |\n", cells[0], cells[1], cells[2]);
        System.out.printf("| %c %c %c |\n", cells[3], cells[4], cells[5]);
        System.out.printf("| %c %c %c |\n", cells[6], cells[7], cells[8]);
        System.out.println("---------");
    }

    public static boolean checkWin(char[] cells, char player) {
        return (cells[0] == player && cells[1] == player && cells[2] == player) ||
                (cells[3] == player && cells[4] == player && cells[5] == player) ||
                (cells[6] == player && cells[7] == player && cells[8] == player) ||
                (cells[0] == player && cells[3] == player && cells[6] == player) ||
                (cells[1] == player && cells[4] == player && cells[7] == player) ||
                (cells[2] == player && cells[5] == player && cells[8] == player) ||
                (cells[0] == player && cells[4] == player && cells[8] == player) ||
                (cells[2] == player && cells[4] == player && cells[6] == player);
    }

    public static boolean checkEmptyCells(char[] cells) {
        for (char cell : cells) {
            if (cell == '_') {
                return true;
            }
        }
        return false;
    }

    public static int countCells(char[] cells, char player) {
        int count = 0;
        for (char cell : cells) {
            if (cell == player) {
                count++;
            }
        }
        return count;
    }

    public static char getPlayer(char[] cells) {
        int xCount = countCells(cells, 'X');
        int oCount = countCells(cells, 'O');
        return (xCount == oCount) ? 'X' : 'O';
    }
}