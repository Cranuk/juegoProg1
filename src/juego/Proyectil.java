package juego;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

<<<<<<< HEAD
public class Proyectil {
		private int x;
		private int y;
		private int ancho;
		private int alto;
		private int velocidad;
		private int escala;
		private Image imgProyectil;
	
	Proyectil(int x, int y, int ancho, int alto, int velocidad){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.velocidad=velocidad;
		this.imgProyectil=Herramientas.cargarImagen("imagenes/proyectilAstro.png");
	}
	void dibujarse(Entorno entorno) {
		//entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.ORANGE);
		entorno.dibujarImagen(imgProyectil, this.x, this.y,0,1);
	}
	public void disparoAstro() {
		this.y-= velocidad;
	}

	
=======
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
<<<<<<< HEAD
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.ORANGE);
	}
=======
	
	void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.ORANGE);
	}
	
>>>>>>> master
	public void disparoAstro() {
		this.y-= velocidad;
	}
	
	public void disparoDest() {
<<<<<<< HEAD
		this.y+= velocidad; // TODO: disparo que hara el destructor
	}
=======
		this.y+= velocidad;
	}
	
>>>>>>> master
>>>>>>> master
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

