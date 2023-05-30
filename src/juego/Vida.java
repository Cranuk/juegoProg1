package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Vida {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	private Image imgVidas;

 	Vida(int x, int y, int ancho , int alto,int velocidad){
 		this.x=x;
 		this.y=y;
 		this.ancho=ancho;
 		this.alto=alto;
 		this.imgVidas=Herramientas.cargarImagen("imagenes/vida.png");
 		this.velocidad=velocidad;
 		redimensionarImagen();
 	}

	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(this.imgVidas, this.x, this.y,0);
	}
	public void mover() {
		this.y+= velocidad;
}
	private void redimensionarImagen() {
        this.imgVidas = this.imgVidas.getScaledInstance(this.ancho, this.alto, Image.SCALE_SMOOTH);
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAlto() {
		return alto;
	}

	public int getAncho() {
		return ancho;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public Image getImgVidas() {
		return imgVidas;
	}
}