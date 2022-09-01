
/*
EJERCICIO 2: Implementar un videojuego (iterativo)
Un jugador lanza 2 dados, se calcula la suma.
Si la suma es 2 ó 12 en el primer lanzamiento, el jugador gana y se
muestra un mensaje.
Si es 7 u 11 el jugador pierde y gana la casa, se muestra un mensaje.
Si la suma es 3, 4, 5, 6, 8, 9, 10 en el primer lanzamiento, dicha suma se
convierte en el “punto del jugador” e imprimir el mensaje “seguirá
jugando”.
Para ganar se debe seguir lanzando hasta sacar el “punto del jugador”,
pierde si saca un 7 antes de alcanzar dicho “punto del jugador”. Al acabar
el juego mostrar si el jugador ganó o perdió y en cuantos turnos.
Jugador Lanzo: 3 + 2 = 5
el punto del jugador es 5. Seguirá jugando
Jugador Lanzo: 2 + 2 = 4
Jugador Lanzo: 3 + 6 = 9
Jugador Lanzo: 2 + 3 = 5
Jugador Gana en 4 turnos
Sin control de repetición medio y en modo CONSOLA.
*/
import java.util.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        Random numRandom = new Random();
        int dado1, dado2, suma, continuar = 0, puntos = 0, turnos = 0;
        do {
            dado1 = (numRandom.nextInt(6) + 1);
            dado2 = (numRandom.nextInt(6) + 1);
            turnos++;
            suma = dado1 + dado2;
            System.out.println("Valores de los dados:\n- Primer dado: " + dado1 + "\n- Segundo dado: " + dado2+"\nEn la suma conseguiste: "+suma);            
            if ((suma == 2 || suma == 12) && continuar != 1) {
                System.out.println("¡FELICITACIONES GANASTE!\nLo hiciste en el primer turno.");
                continuar = 0;
            } else if (suma == 7 || suma == 11) {
                if (continuar == 0) {
                    System.out.println("PERDISTE\nEn el primer turno... si entras de nuevo pueda que ganes.");
                    continuar = 0;
                } else {
                    System.out.println("PERDISTE\nHas jugado " + turnos + " turnos.");
                    continuar = 0;
                }
            } else if (continuar != 1) {
                System.out.println("¡MUY BIEN!\nHas obtenido " + suma
                        + " puntos.\nPara ganar en el siguiente lanzamiento tienes que conseguir esta misma cantidad en la suma de dados.");
                puntos = suma;
                continuar = 1;
            } else if (continuar == 1) {
                if (puntos == suma) {
                    System.out.println("¡FELICITACIONES HAS GANADO!\nLo hiciste  en " + turnos
                            + " turnos.");
                    continuar = 0;
                } else {
                    System.out.println("¡CASI!\nHas obtenido " + suma
                            + " puntos.\nSigues en juego, recuerda que para ganar tienes que conseguir " + puntos
                            + " en la suma de los dos dados.");
                    continuar = 1;
                }
            }
        } while (continuar == 1);
    }
}