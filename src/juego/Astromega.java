package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import javax.sound.sampled.Clip;

public class Astromega {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private int velocidad;
	private Image imgAstromega;
	public final char TECLA_D = 'D';
	public final char TECLA_A = 'A';
	private Clip sonido = entorno.Herramientas.cargarSonido("sonidos/laser.wav");
	
	
	Astromega(int x, int y, int ancho , int alto,int velocidad){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.imgAstromega=Herramientas.cargarImagen("imagenes/astromega.png");
		this.velocidad=velocidad;
		redimensionarImagen();
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(this.imgAstromega, this.x, this.y,0);
	}
	
	private void redimensionarImagen() {
        this.imgAstromega = this.imgAstromega.getScaledInstance(this.ancho, this.alto, Image.SCALE_SMOOTH);
    }
	
	Proyectil disparar() {
		entorno.Herramientas.play("sonidos/laser.wav");
		return new Proyectil (this.x, this.y,15,25,10);
		
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