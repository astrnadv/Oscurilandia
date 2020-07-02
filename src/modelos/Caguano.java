package modelos;

public class Caguano extends Carro {
	
	private int alcanceTiro;
	private String colorConfeti;
	
	public Caguano() {
		this.alcanceTiro=(int) (Math.random()* 15);
		this.colorConfeti="verde";		
	}
	
	public Caguano(int alcanceTiro, String colorConfeti) {
		this.alcanceTiro=alcanceTiro;
		this.colorConfeti=colorConfeti;
	}
	
	
	public int getAlcanceTiro() {
		return alcanceTiro;
	}

	public void setAlcanceTiro(int alcanceTiro) {
		this.alcanceTiro = alcanceTiro;
	}

	public String getColorConfeti() {
		return colorConfeti;
	}

	public void setColorConfeti(String colorConfeti) {
		this.colorConfeti = colorConfeti;
	}

	@Override
	public String toString() {
		return "Caguano [alcanceTiro=" + alcanceTiro + ", colorConfeti=" + colorConfeti + "]";
	}


	@Override
	public String getTipo() {
		return "Caguano";
	}

}
