package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Ion {
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private int velocidad;
	private Image imagIon;
	
	Ion (double x, double y, int ancho, int alto, int velocidad){
		this.x=x;
		this.y=y;	
		this.ancho=ancho;
		this.alto=alto;
		this.velocidad=velocidad;
		this.imagIon=Herramientas.cargarImagen("imagenes/proyectilAstro.png");
		redimensionarImagen();
	}
	
	void dibujarse(Entorno entorno) {
		//entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.white);
		entorno.dibujarImagen(imagIon, this.x, this.y,0,1);
	}
	private void redimensionarImagen() {
        this.imagIon = this.imagIon.getScaledInstance(this.ancho, this.alto, Image.SCALE_SMOOTH);
    }
	
	public void disparoDestruc() {
		this.y+= velocidad;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
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
