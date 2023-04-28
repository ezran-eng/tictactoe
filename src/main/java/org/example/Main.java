package org.example;

/*

Descripción
El tres en raya es un juego conocido en todo el mundo. Cada país puede tener su propia versión del nombre, a veces las reglas son diferentes, pero la esencia del juego sigue siendo la misma. A continuación se presentan las reglas principales que pueden resultarle familiares desde la infancia.
El tres en raya se juega por dos jugadores en una cuadrícula de 3x3. Uno de los jugadores es 'X', y el otro jugador es 'O'. X juega primero, luego O toma el siguiente turno, y así sucesivamente.
Los jugadores escriben 'X' y 'O' en un campo de 3x3.
El primer jugador que coloca 3 X o 3 O en línea recta (incluyendo diagonales) gana el juego.

Objetivos
Tu primera tarea en este proyecto es imprimir la cuadrícula del juego en la salida de la consola. Usa lo que has aprendido sobre la función print() para imprimir tres líneas, cada una conteniendo tres caracteres (X's y O's) para representar un juego de tres en raya en el que todos los campos de la cuadrícula han sido llenados.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("X O X\n O X O\n X X O");
    }
}