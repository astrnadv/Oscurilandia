package helpers;

public class NombreAleatorio {

	private final String[] NOMBRES = { "Andrea", "David", "Juan","Roberto","Ignacia","Florencia","Mat�as","Josefa",
			"Raquel","Mar�a","Ignacio","Andr�s","Marcela","Carolina","Bel�n","Iv�n","Tom�s","Marcelo","Javiera","Claudio" };

	private final String[] APELLIDOS = { "Gomez", "Guerrero","Bravo","Figueroa","Garc�a","Gonzalez","Gutierrez","P�rez",
			"Sep�lveda","Garrido","Fa�ndez","Flores","Soto","Nu�ez","Herrera","Araya","Albornoz","Diaz"};

	private String nombreAleatorio;

	public String generarNombreAleatorio() {

		this.nombreAleatorio = NOMBRES[(int) (Math.floor(Math.random() * NOMBRES.length))] + " "
				+ APELLIDOS[(int) (Math.floor(Math.random() * APELLIDOS.length))];

		return nombreAleatorio;
	}

	public String getNombreAleatorio() {
		return nombreAleatorio;
	}

	public void setNombreAleatorio(String nombreAleatorio) {
		this.nombreAleatorio = nombreAleatorio;
	}

	@Override
	public String toString() {
		return "NombreAleatorio [nombreAleatorio=" + nombreAleatorio + "]";
	}
	
	
	
	

}
