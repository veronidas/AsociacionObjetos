package app;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Equipo;
import modelos.Jugador;

// Crear jugador: Esta opción te permitirá crear un nuevo jugador. Deberás pedir al usuario el nombre del jugador y mostrar la lista de equipos disponibles para que elija uno, si no hay equipos creados entonces debería mostrar un mensaje que diga que no hay equipos disponibles y setear null.

// Asignar jugador a equipo: Con esta opción, podrás asignar un jugador existente a un equipo existente. Deberás permitir al usuario seleccionar de la lista de jugadores y equipos existentes.

// Mostrar lista de jugadores: Esta opción mostrará una lista de todos los jugadores creados, junto con el nombre del equipo al que están asignados, si corresponde.

// Mostrar lista de equipos: Esta opción mostrará una lista de todos los equipos creados.

// Salir: Esta opción termina la ejecución del programa.

public class Menu {

    public static ArrayList<Equipo> equipos = new ArrayList<>();
    public static ArrayList<Jugador> jugadores = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void menu() {
        int option = 0;

        do {
            
            System.out.println("1. Crear jugador");
            System.out.println("2. Crear equipo");
            System.out.println("3. Asignar jugador a equipo");
            System.out.println("4. Mostrar lista de jugadores");
            System.out.println("5. Mostrar lista de equipos");
            System.out.println("6. Salir");
            System.out.println("Ingrese la opcion deseada:");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    crearEquipo();
                    break;
                case 3:
                    asignarJugadorAEquipo();
                    break;
                case 4:
                    mostrarJugadores();
                    break;
                case 5:
                    mostrarEquipos();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (option != 6);
    }

    private static void crearJugador() {
        System.out.print("Ingrese el nombre del jugador:");
        String nombreJugador = sc.nextLine();
        sc.nextLine();
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles, solo se guardo el jugador");
            jugadores.add(new Jugador(nombreJugador, null));
        } else {
            mostrarEquipos();
            System.out.print("Ingrese el numero de la lista al que pertece el jugador: ");
            int num = sc.nextInt();
            sc.nextLine();
            jugadores.add(new Jugador(nombreJugador, equipos.get(num-1)));

        }
    }

    private static void crearEquipo() {
        System.out.print("Ingrese el nombre del equipo:");
        String nombreEquipo= sc.nextLine();
        sc.nextLine();
        equipos.add(new Equipo(nombreEquipo));
        }
    
    private static void asignarJugadorAEquipo(){
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles");
        } else if(equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles");
        } else {

            mostrarJugadores();
            System.out.print("Ingrese el numero del jugador:");
            int numJugador = sc.nextInt();
            sc.nextLine();

            mostrarEquipos();
            System.out.print("Ingrese el numero del equipo:");
            int numEquipo = sc.nextInt();
            jugadores.get(numJugador-1).setEquipo(equipos.get(numEquipo-1));;
        }
    }

    private static void mostrarJugadores(){
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println("Jugador " + (i + 1) + ": " + jugadores.get(i).getNombre());
            }
    }

    private static void mostrarEquipos(){
            for (int i = 0; i < equipos.size(); i++) {
                System.out.println("Equipo " + (i + 1) + ": " + equipos.get(i).getNombreEquipo());
            }
    }

}
