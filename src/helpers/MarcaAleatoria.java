package helpers;

public class MarcaAleatoria {
	
	private final String[] MARCAS = { "Volvo", "Renault", "Chevrolet", "Iveco", "Ford", "Volkswagen", "Mercedes Benz",
			"Kenworth", "Scania", "Fuso", "Thomas"};

	private String marcaAleatoria;

	public String generarMarcaAleatoria() {

		this.marcaAleatoria = MARCAS[(int) (Math.floor(Math.random() * MARCAS.length))] ;

		return marcaAleatoria;
	}

	public String getMarcaAleatoria() {
		return marcaAleatoria;
	}

	public void setMarcaAleatoria(String marcaAleatoria) {
		this.marcaAleatoria = marcaAleatoria;
	}

	@Override
	public String toString() {
		return "MarcaAleatoria [marcaAleatoria=" + marcaAleatoria + "]";
	}
	
	
	
}
