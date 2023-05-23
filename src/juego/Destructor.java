package juego;

import java.awt.Color;
import java.util.Random;
import entorno.Entorno;

public class Destructor {
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private int velocidad;
	private double angulo;
	private static final double anguloDer = 45;
	private static final double anguloIzq = 315;

	/**
	 * Constructor de la clase destructor
	 * 
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 * @param velocidad
	 */
	Destructor(int x, int y, int ancho, int alto, int velocidad) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
		this.angulo = entorno.Herramientas.radianes(anguloDer);
	}

	// TODO: getters and setters
	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
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

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	// TODO: metodos
	/**
	 * Dibuja el objeto dentro del entorno
	 * 
	 * @param entorno
	 */
	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.MAGENTA);
	}

	/**
	 * Movimiento del destructor que va en diagonal 45 grados a la derecha 315
	 * grados a la izquierda
	 */
	public void mover(Entorno entorno) {
		this.x += velocidad * Math.sin(angulo);
	    this.y += velocidad * Math.cos(angulo);
	}

	/**
	 * Cambio de dirección
	 */
	public void cambiarAngulo() {
	    this.setAngulo(anguloIzq);
	    this.x += velocidad * Math.sin(this.getAngulo());
	    this.y += velocidad * Math.cos(this.getAngulo());
	}


	/**
	 * Este metodo reinicio la posicion Y del destructor si no tuvo interaccion con
	 * la nave del jugador choque o disparo
	 * 
	 * @param entorno
	 */
	public void respawn(Entorno entorno) {
		Random rand = new Random();
		this.x = rand.nextInt(50, entorno.ancho() - 50);
		this.y = 50;
	}
}