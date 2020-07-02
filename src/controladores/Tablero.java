package controladores;

import java.util.*;

import modelos.Caguano;
import modelos.Carro;
import modelos.Huevo;
import modelos.Kromi;
import modelos.Trupalla;
import modelos.Ubicacion;

public class Tablero {

	private final static int FILAS = 15;
	private final static int COLUMNAS = 15;

	private final int TAMANIO_KROMI = 3;
	private final int TAMANIO_CAGUA = 2;
	private final int TAMANIO_TRUPA = 1;

	private final int SCORE_KROMI = 3;
	private final int SCORE_CAGUA = 2;
	private final int SCORE_TRUPA = 1;

	private final int CANT_KROMI=3;
	private final int CANT_CAGUA=5;
	private final int CANT_TRUPA=10;
	
	private final int EXTRA_KROMI=10;
	private final int EXTRA_CAGUA=7;

	private String[][] tablero;
	private int puntaje;
	private boolean mostrarMatriz;
	
    private List<Huevo> huevos;
    private List<Carro> carros;
	
	
	ArrayList<Carro> listaCarros = new ArrayList<Carro>();
	ArrayList<Huevo> listaHuevos = new ArrayList<Huevo>();
	

	public Tablero(boolean verTablero) {

		this.mostrarMatriz = verTablero;
		this.tablero = new String[FILAS][COLUMNAS];
		this.puntaje = 0;

		this.huevos = new ArrayList<>();
		this.carros = new ArrayList<>();
		
		crearCarro();

	}

	public void crearCarro() {

		for (int i = 0; i < 3; i++) {
			crearKromi();
		}

		for (int i = 0; i < 5; i++) {
			crearCaguano();
		}

		for (int i = 0; i < 10; i++) {
			crearTrupalla();
		}

	}

	public String lanzarHuevo(int fila, int columna) {

		String celda = tablero[fila][columna];
		Huevo huevo = new Huevo(puntaje, new Ubicacion(fila, columna));
		huevos.add(huevo);
		
		return celda;

	}

	public int calcularPuntaje() {
	
		Huevo lastHuevo = huevos.get(huevos.size() -1 );
		Ubicacion ubHuevo = lastHuevo.getUbicacion();

		int fila = ubHuevo.getFila();
		int columna = ubHuevo.getColumna();		
		int puntaje=0;
		
		if (this.tablero[fila][columna] != null) {
			if (tablero[fila][columna].contentEquals("K")) {
				puntaje = +SCORE_KROMI;
			} else if (tablero[fila][columna].contentEquals("C")) {
				puntaje = +SCORE_CAGUA;
			} else if (tablero[fila][columna].contentEquals("T")){
				puntaje=+ SCORE_TRUPA;
			}
		}
		
		Carro carro = hayCarro(fila, columna);
		
		if(carroEliminado(carro)) {
            String etiqueta = tablero[fila][columna];
            
            if(etiqueta != null) {
                if(etiqueta.equals("K")) 
                    puntaje += EXTRA_KROMI;
                else if(etiqueta.equals("C"))
                    puntaje += EXTRA_CAGUA;
            }
        }   

		this.tablero[fila][columna] = "H";
		this.puntaje += puntaje;		
		
		return this.puntaje;		
	}
	
	public Carro hayCarro(int fila, int columna) {
		
		for(Carro carro : this.carros) {
			List<Ubicacion> ubicaciones = carro.getUbicaciones();
			
			for(Ubicacion u : ubicaciones) {
				if(u.getFila()==fila && u.getColumna()==columna);
					return carro;
			}
		}
		return null;
				
	}
	
	public boolean carroEliminado(Carro carro) {
		
		List<Ubicacion> ubicaciones = carro.getUbicaciones();
        int posicionesAtacadas = 0;
        
        for(Ubicacion ubicacion : ubicaciones) {
            for(Huevo huevo : this.huevos) {
                Ubicacion ubHuevo = huevo.getUbicacion();
                
                if(ubicacion.getFila() == ubHuevo.getFila() && 
                        ubicacion.getColumna() == ubHuevo.getColumna())
                    posicionesAtacadas++;
            }
        }
        
        if(posicionesAtacadas == ubicaciones.size())
            return true;
        
		return false;
	}

	public void mostrarMatriz(Tablero tablero) {

		for (int i = 0; i < COLUMNAS; i++) {
			
			System.out.println("");
			for (int j = 0; j < FILAS; j++) {
				if(this.tablero[i][j]!=null) {
					System.out.print("| "+this.tablero[i][j]+" |");
					
				} else {
					System.out.print("|   |");
				}
			}
		}System.out.println("");
	}
	
	public void mostrarMatrizHuevos(Tablero tablero) {

		for (int i = 0; i < COLUMNAS; i++) {
			
			System.out.println("");
			for (int j = 0; j < FILAS; j++) {
				if(this.tablero[i][j]!=null && this.tablero[i][j].contentEquals("H")) {
					System.out.print("| "+this.tablero[i][j]+" |");
					
				} else {
					System.out.print("|   |");
				}
			}
		}System.out.println("");
	}


	
	public void crearKromi() {
		int fila;
		int columna;

		do {
			fila = (int) (Math.random() * (FILAS - (TAMANIO_KROMI + 1)));
			columna = (int) (Math.random() * COLUMNAS);
		} while (!isViable(fila, columna, true));

		Kromi kromi = new Kromi();
		for (int i = 0; i < TAMANIO_KROMI; i++) {
			kromi.agregarUbicacion(new Ubicacion(fila + i, columna));
			this.tablero[fila + i][columna] = "K";
		}

		this.carros.add(kromi);
	}
	
	public void crearCaguano() {
		int fila;
		int columna;

		do {
			fila = (int) (Math.random() * FILAS);
			columna = (int) (Math.random() * (COLUMNAS - (TAMANIO_CAGUA)));
		} while (!isViable(fila, columna, false));

		Caguano caguano = new Caguano();
		for (int i = 0; i < TAMANIO_CAGUA; i++) {
			caguano.agregarUbicacion(new Ubicacion(fila, columna+i));
			this.tablero[fila][columna+i] = "C";
		}

		this.carros.add(caguano);
		
	}
	
	public void crearTrupalla() {
		int fila;
		int columna;
		
		do {
            fila = (int) (Math.random() * FILAS);
            columna = (int) (Math.random() * COLUMNAS);
        } while(!isViable(fila, columna));
        
        this.tablero[fila][columna] = "T";
        
        Trupalla trupalla = new Trupalla();
        trupalla.agregarUbicacion(new Ubicacion(fila, columna));
        
        this.carros.add(trupalla);
	}
	
	
	
	private boolean isViable(int fila, int columna) {
		if (tablero[fila][columna] != null)
			return false;

		return true;
	}
	
	private boolean isViable(int fila, int columna, boolean vertical) {
		if (vertical) {
			for (int i = 0; i < TAMANIO_KROMI; i++) {
				if (!isViable(fila + i, columna))
					return false;

			}
		} else {
			for (int i = 0; i < TAMANIO_CAGUA; i++) {
				if (!isViable(fila, columna + i))
					return false;
			}
		}

		return true;
	}

	public String[][] getTablero() {
		return tablero;
	}

	public void setTablero(String[][] tablero) {
		this.tablero = tablero;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	
	
	
	
	
}
