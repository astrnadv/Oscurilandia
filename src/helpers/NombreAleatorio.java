package helpers;

public class NombreAleatorio {

	private final String[] NOMBRES = { "Andrea", "David", "Juan","Roberto","Ignacia","Florencia","Matías","Josefa",
			"Raquel","María","Ignacio","Andrés","Marcela","Carolina","Belén","Iván","Tomás","Marcelo","Javiera","Claudio" };

	private final String[] APELLIDOS = { "Gomez", "Guerrero","Bravo","Figueroa","García","Gonzalez","Gutierrez","Pérez",
			"Sepúlveda","Garrido","Faúndez","Flores","Soto","Nuñez","Herrera","Araya","Albornoz","Diaz"};

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
