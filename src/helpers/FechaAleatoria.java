package helpers;

import java.util.*;

public class FechaAleatoria {

	private String fecha;

	int dia, mes, anio;

	public FechaAleatoria() {

		int yyyy = random(1950, 2020);
		int mm = random(1, 12);
		int dd = 0;

		switch (mm) {
		case 2:
			if (esBisiesto(yyyy)) {
				dd = random(1, 29);
			} else {
				dd = random(1, 28);
			}
			break;

		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dd = random(1, 31);
			break;

		default:
			dd = random(1, 30);
			break;
		}

		String anio = Integer.toString(yyyy);
		String mes = Integer.toString(mm);
		String dia = Integer.toString(dd);

		if (mm < 10) {
			mes = "0" + mm;
		}

		if (dd < 10) {
			dia = "0" + dd;
		}

		this.fecha = dia + '/' + mes + '/' + anio;

	}

	public static int random(int lowerBound, int upperBound) {
		return (lowerBound + (int) Math.round(Math.random() * (upperBound - lowerBound)));
	}

	public static boolean esBisiesto(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		int noOfDays = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);

		if (noOfDays > 365) {
			return true;
		}

		return false;
	}

	public int anioRandom() {
		anio = random(1950, 2020);
		return anio;
	}

	public String getFecha() {
		return fecha;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "FechaAleatoria [fecha=" + fecha + "]";
	}

}
