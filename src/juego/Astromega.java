package juego;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;

public class Astromega {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	private Image imgAstromega;
	
	Astromega(int x, int y, int ancho , int alto,int velocidad){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.imgAstromega=Herramientas.cargarImagen("imagenes/astromega.png");
		this.velocidad=velocidad;
	}
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(this.imgAstromega, this.x, this.y,0);
	}
	Proyectil disparar() {
		
		return new Proyectil (this.x, this.y,1,1,7);
	}
	
	void moverDerecha() {
		this.x=this.x + this.velocidad;
	}
	
	void moverIzquierda() {
		this.x=this.x - this.velocidad;
	}
	public int getX() {
		return x;
	}
	public int getAncho() {
		return ancho;
	}
	public int getAlto() {
		return alto;
	}

	public int getY() {
		return y;
	}

}