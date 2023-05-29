package juego;

import java.util.Random;
import entorno.Entorno;
import entorno.Herramientas;
import java.awt.Image;

public class Destructor {
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private int velocidad;
	private double angulo;
	private int puntuacion;
	private Image destructor;
	
	Destructor(int x, int y, int ancho, int alto, int velocidad){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.velocidad=velocidad;
		this.angulo = entorno.Herramientas.radianes(45);
		this.puntuacion = 50;
		this.destructor = Herramientas.cargarImagen("imagenes/destructor.png");
		redimensionarImagen();
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(this.destructor, this.x, this.y,0);
	}
	
	private void redimensionarImagen() {
        this.destructor = this.destructor.getScaledInstance(this.ancho, this.alto, Image.SCALE_SMOOTH);
    }
	
	// TODO: getters and setters
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
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
		this.angulo = entorno.Herramientas.radianes(angulo);
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	
	// TODO: metodos
	/**
	 * Movimiento del destructor que va en diagonal 45 grados a la derecha 315
	 * grados a la izquierda
	 */
	public void mover() {
		this.x += velocidad * Math.sin(angulo);
	    this.y += velocidad * Math.cos(angulo);
	}
	
	/**
	 * Llamamos al objeto para realizar el disparo del destructor
	 */
	Ion disparaion() {
		return new Ion (this.x,this.y,15,40,2);
	}
	
	/**
	 * Este metodo reinicio la posicion Y del destructor si no tuvo interaccion con
	 * la nave del jugador choque o disparo
	 * 
	 * @param entorno
	 */
	public void respawn(Entorno entorno){
		this.x = this.getX();
		this.y = 100;
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
}