# Tic-Tac-Toe
## Descripcion
He creado un programa que analiza el estado del juego para determinar si alguno de los jugadores ya ha ganado el juego o si todavía está en curso, si el juego es un empate, o si el usuario ha ingresado un estado de juego imposible (dos ganadores o con un jugador que ha hecho demasiados movimientos).
## Objetivos
En esta etapa, he creado un programa que analiza el estado del juego para determinar si alguno de los jugadores ya ha ganado el juego o si todavía está en curso, si el juego es un empate, o si el usuario ha ingresado un estado de juego imposible (dos ganadores o con un jugador que ha hecho demasiados movimientos).

Objetivos
En esta etapa, mi programa debe:

1. Tomar una cadena ingresada por el usuario e imprimir la cuadrícula del juego como en la etapa anterior.
2. Analizar el estado del juego e imprimir el resultado. Los estados posibles son los siguientes:

* El juego no ha terminado cuando ninguno de los dos lados tiene tres en línea, pero la cuadrícula todavía tiene celdas vacías.
* Empate cuando ninguno de los lados tiene tres en línea y la cuadrícula no tiene celdas vacías.
* X gana cuando la cuadrícula tiene tres X en línea (incluyendo diagonales).
* O gana cuando la cuadrícula tiene tres O en línea (incluyendo diagonales).
* Imposible cuando la cuadrícula tiene tres X en línea y tres O en línea, o hay muchas más X que O o viceversa (la diferencia debe ser 1 o 0; si la diferencia es 2 o más, entonces el estado del juego es imposible).
* 
En esta etapa, asumimos que tanto X como O pueden comenzar el juego. He elegido usar un guion bajo _ para imprimir las celdas vacías.