package modelos;

public class Huevo {
	
	private Ubicacion ubicacion;
	private int puntajeLanzamiento;
	
	public Huevo(int puntaje, Ubicacion ubicacion) {
		this.puntajeLanzamiento=puntaje;
		this.ubicacion=ubicacion;		
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getPuntajeLanzamiento() {
		return puntajeLanzamiento;
	}

	public void setPuntajeLanzamiento(int puntajeLanzamiento) {
		this.puntajeLanzamiento = puntajeLanzamiento;
	}

	@Override
	public String toString() {
		return "Huevo [ubicacion=" + ubicacion + ", puntajeLanzamiento=" + puntajeLanzamiento + "]";
	}
}
