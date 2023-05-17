package juego;

import java.awt.Color;

import entorno.Entorno;

public class Proyectil {
		private int x;
		private int y;
		private int ancho;
		private int alto;
		private int velocidad;
	
	Proyectil(int x, int y, int ancho, int alto, int velocidad){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.velocidad=velocidad;
	}
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.MAGENTA);
	}
	public void mover() {
		this.y-= velocidad;
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


