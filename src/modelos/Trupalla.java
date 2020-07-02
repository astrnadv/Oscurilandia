package modelos;

import helpers.NombreAleatorio;

public class Trupalla extends Carro{
	private int nivelArmadura=5;
	private String nombreManipulador;
	
	public Trupalla() {
		this.nivelArmadura=(int)(Math.random() * 6);
		this.nombreManipulador= new NombreAleatorio().getNombreAleatorio();		
	}
	
	public Trupalla(int nivelArmadura,String nombreManipulador) {
		this.nivelArmadura=nivelArmadura;
		this.nombreManipulador= nombreManipulador;
	}
	
	
	
	
	public int getNivelArmadura() {
		return nivelArmadura;
	}

	public void setNivelArmadura(int nivelArmadura) {
		this.nivelArmadura = nivelArmadura;
	}

	public String getNombreManipulador() {
		return nombreManipulador;
	}

	public void setNombreManipulador(String nombreManipulador) {
		this.nombreManipulador = nombreManipulador;
	}
	
	

	@Override
	public String toString() {
		return "Trupalla [nivelArmadura=" + nivelArmadura + ", nombreManipulador=" + nombreManipulador + "]";
	}

	@Override
	public String getTipo() {
		return "Trupalla ";
	}
}
