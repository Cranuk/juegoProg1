package juego;

import java.awt.Color;

import entorno.Entorno;

public class Asteroide {
	private int x;
	private int y;
	private int radio;
	private int velocidad;
		
	Asteroide(int x, int y, int radio, int velocidad){
		this.x=x;
		this.y=y;
		this.radio=radio;
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

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	//TODO: Metodos
	public void dibujarse(Entorno entorno) {
		entorno.dibujarCirculo(this.x, this.y, this.radio, Color.white);
	}
	
	public void mover() {
		this.y+= velocidad;
	}

		
}
