package juego;

import java.awt.Color;

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
	}

	public int getY() {
		return y;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public int getVelocidad() {
		return velocidad;
	}
}