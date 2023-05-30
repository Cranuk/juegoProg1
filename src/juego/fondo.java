package juego;

import java.awt.Image;

import entorno.Herramientas;
import javax.sound.sampled.Clip;

import entorno.Entorno;


public class fondo {
	private Image fondo;
	
	
	fondo() {
        this.fondo = entorno.Herramientas.cargarImagen("imagenes/fondo.png");
        //entorno.Herramientas.play("sonidos/songFondo.wav");
    
    }
	
	public void dibujarse(Entorno entorno) {
		
		entorno.dibujarImagen(this.fondo, entorno.ancho(), entorno.alto(),0);
		
	}
	
}
