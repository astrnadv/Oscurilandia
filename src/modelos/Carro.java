package modelos;

	import java.util.*;
	import helpers.FechaAleatoria;
	
public abstract class Carro {
	
	private int cantidadOcupantes;
	private String fechaIngreso;
	private Ubicacion ubicacion;
	
	private List<Ubicacion> ubicaciones;
	
	public Carro() {
		this.cantidadOcupantes=(int)Math.floor(Math.random()*15+1);
		this.fechaIngreso= new FechaAleatoria().getFecha();
		this.ubicaciones=new ArrayList<>();
	}
	
	public abstract String getTipo();
	
	public void agregarUbicacion(Ubicacion ubicacion) {
		this.ubicaciones.add(ubicacion);
	}

	public int getCantidadOcupantes() {
		return cantidadOcupantes;
	}

	public void setCantidadOcupantes(int cantidadOcupantes) {
		this.cantidadOcupantes = cantidadOcupantes;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	@Override
	public String toString() {
		return "Carro [cantidadOcupantes=" + cantidadOcupantes + ", fechaIngreso=" + fechaIngreso + ", ubicacion="
				+ ubicacion + ", ubicaciones=" + ubicaciones + "]";
	}
	
	

}
