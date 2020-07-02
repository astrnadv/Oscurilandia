package controladores;

import java.util.*;

public class Main {

	public static void queSucede(Tablero tablero, int fila, int columna) {

		String celdaAfectada = tablero.lanzarHuevo(fila, columna);

		System.out.printf("\nAtacando celda(%d, %d): ", fila+1, columna+1);

		if (celdaAfectada != null) {
			if (celdaAfectada.equals("H"))
				System.out.println("UPS! ya habías tirado acá!");
			else if (celdaAfectada.equals("K"))
				System.out.println("Le achuntaste a una Kromi!");
			else if (celdaAfectada.equals("C"))
				System.out.println("Le achuntaste a un Caguano!");
			else
				System.out.println("Le achuntaste a una Trupalla!");
		} else
			System.out.println("No le achuntaste a nada!");
	}

	public static void main(String[] args) {

		int opc = 0;
		Scanner scn = new Scanner(System.in);
		Tablero tablero = new Tablero(false);
		boolean error = false;

		System.out.println("** Bienvenido a Oscurilandia **");

		do {
			System.out.println("\nMENÚ");
			System.out.println("1.- Lanzar huevo");
			System.out.println("2.- Ver donde he lanzado huevos");
			System.out.println("3.- Ver puntaje");
			System.out.println("4.- Quiero hacer trampa :c");
			System.out.println("5-. Salir y ver tablero final");

			do {

				do {
					System.out.println("Qué desea hacer?: ");
					try {
						opc = scn.nextInt();
						error = false;
					} catch (Exception e) {
						error = true;
						scn.next();
						System.out.println("Dato inválido");
					}

				} while (error);

				if (opc < 1 || opc > 5) {
					System.out.println("Opción inválida, ingresa nuevamente");
				}

			} while (opc < 1 || opc > 5);

			switch (opc) {
			case 1:
				int fila = 0, columna = 0;
				// System.out.println("Ingrese fila (del 1 al 15):");

				do {

					do {
						System.out.print("Ingresa una fila (del 1 al 15): ");
						try {
							fila = scn.nextInt() - 1;
							error = false;
						} catch (Exception e) {
							error = true;
							scn.next();
							System.out.println("Dato inválido");
						}

					} while (error);

					if (fila < 0 || fila > 15) {
						System.out.println("Número inválido, ingresa nuevamente");
					}

				} while (fila < 0 || fila > 15);

				do {

					do {
						System.out.print("Ingresa una columna (del 1 al 15): ");
						try {
							columna = scn.nextInt() - 1;
							error = false;
						} catch (Exception e) {
							error = true;
							scn.next();
							System.out.println("Dato inválido");
						}

					} while (error);

					if (columna < 0 || columna > 15) {
						System.out.println("Número inválido, ingresa nuevamente");
					}

				} while (columna < 0 || columna > 15);

				queSucede(tablero, fila, columna);
				tablero.lanzarHuevo(fila, columna);
				tablero.calcularPuntaje();

				System.out.println("Tu puntaje es de: " + tablero.getPuntaje() + "\n");
				break;
			case 2:
				tablero.mostrarMatrizHuevos(tablero);
				break;
			case 3:
				System.out.println("Tu puntaje actual es de: " + tablero.getPuntaje() + "\n");

				break;
			case 4:
				System.out.println("Eres un TRAMPOSOO!!!");
				tablero.mostrarMatriz(tablero);
				break;
			case 5:
				System.out.println("Gracias por jugar");
				tablero.mostrarMatriz(tablero);

				break;

			}
		} while (opc != 5);

	}

}
