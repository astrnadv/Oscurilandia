package modelos;

	import java.util.*;
	import helpers.FechaAleatoria;
	import helpers.MarcaAleatoria;
	
public class Kromi extends Carro{
	
	private int anioFabricacion;
	private String marca;
		
	public Kromi() {
		this.anioFabricacion= new FechaAleatoria().anioRandom();
		this.marca= new MarcaAleatoria().getMarcaAleatoria();
	}
	
	public Kromi(int anioFabricacion, String marca) {
		this.anioFabricacion= anioFabricacion;
		this.marca= marca;
	}
	
	
	
	public int getAnioFabricacion() {
		return anioFabricacion;
	}



	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	@Override
	public String toString() {
		return "Kromi [anioFabricacion=" + anioFabricacion + ", marca=" + marca + "]";
	}



	@Override
	public String getTipo() {
		return "Kromi";
	}

}
