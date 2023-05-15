package juego;

import java.awt.Color;
import java.util.Random;
import entorno.Entorno;

public class Destructor {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	
	Destructor(int x, int y, int ancho, int alto, int velocidad){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.velocidad=velocidad;
	}
	
	//TODO: getters and setters
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	
	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	//TODO: metodos
	/**
	 * dibuja el objeto dentro del entorno
	 * @param entorno
	 */
	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.MAGENTA);
	}
	
	/**
	 * aumenta la coordenada Y mediante el uso de la variable velocidad
	 */
	public void mover() {
		this.y+=velocidad;
	}
	
	/**
	 * Este metodo realiza el cambio de posicion del objeto dentro del entorno si no fue puesto en null
	 * @param entorno
	 */
	public void respawn(Entorno entorno) {
		Random rand = new Random();
		this.x = rand.nextInt(50,entorno.ancho()-50);
		this.y = 50;
	}
}