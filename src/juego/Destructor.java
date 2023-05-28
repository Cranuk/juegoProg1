package juego;

import java.awt.Color;
import java.util.Random;
import entorno.Entorno;

public class Destructor {
<<<<<<< HEAD
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
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.PINK);
	}
	Ion disparaion() {
		return new Ion (this.x,this.y,15,40,2);
	}
	
	public void mover() {
		this.y-=velocidad;
	}
	public int getX() {
		return x;
=======
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private int velocidad;
	private double angulo;
<<<<<<< HEAD
	private static final double anguloDer = 45;
	private static final double anguloIzq = 315;
=======
	private int puntuacion;
>>>>>>> master

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
<<<<<<< HEAD
		this.angulo = entorno.Herramientas.radianes(anguloDer);
=======
		this.angulo = entorno.Herramientas.radianes(45);
		this.puntuacion = 50;
>>>>>>> master
	}

	// TODO: getters and setters
	public double getX() {
		return x;
<<<<<<< HEAD
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
>>>>>>> master
	}

	public void setY(double y) {
		this.y = y;
=======
	}

	public double getY() {
		return y;
>>>>>>> master
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
<<<<<<< HEAD
=======
	
	public double getAngulo() {
		return angulo;
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	public void setAlto(int alto) {
		this.alto = alto;
	}
>>>>>>> master

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

<<<<<<< HEAD
	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
=======
	public void setAngulo(double angulo) {
		this.angulo = entorno.Herramientas.radianes(angulo);
	}
	
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
>>>>>>> master
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
<<<<<<< HEAD
	public void mover(Entorno entorno) {
=======
	public void mover() {
>>>>>>> master
		this.x += velocidad * Math.sin(angulo);
	    this.y += velocidad * Math.cos(angulo);
	}

	/**
<<<<<<< HEAD
	 * Cambio de dirección
	 */
	public void cambiarAngulo() {
	    this.setAngulo(anguloIzq);
	    this.x += velocidad * Math.sin(this.getAngulo());
	    this.y += velocidad * Math.cos(this.getAngulo());
	}


	/**
=======
>>>>>>> master
	 * Este metodo reinicio la posicion Y del destructor si no tuvo interaccion con
	 * la nave del jugador choque o disparo
	 * 
	 * @param entorno
	 */
<<<<<<< HEAD
	public void respawn(Entorno entorno) {
		Random rand = new Random();
		this.x = rand.nextInt(50, entorno.ancho() - 50);
		this.y = 50;
	}
=======
	public void respawn(Entorno entorno){
		Random rand= new Random();
		this.x = rand.nextInt(20, entorno.ancho()-20);
		this.y = 100;
	}
	
	Proyectil disparar() {
		int disX = (int) this.getX();
		int disY = (int) this.getY();
		return new Proyectil (disX, disY,15,40,4);
	}
	
	public boolean ubicarEn1(Entorno entorno) {// 0 a 199
		int sector = entorno.ancho()/4;
		boolean xSector = this.x >= 0 && this.x < sector;
		return xSector;
	}
	
	public boolean ubicarEn2(Entorno entorno) {//200 a 399
		int sector = entorno.ancho()/4;
		boolean xSector = this.x >= sector && this.x < sector*2;
		return xSector;
	}
	
	public boolean ubicarEn3(Entorno entorno) {//400 a 599
		int sector = entorno.ancho()/4;
		boolean xSector = this.x >= sector*2 && this.x < sector*3;
		return xSector;
	}
	
	public boolean ubicarEn4(Entorno entorno) {//600 a 799
		int sector = entorno.ancho()/4;
		boolean xSector = this.x >= sector*3 && this.x < sector*4;
		return xSector;
	}
	
	
>>>>>>> master
}